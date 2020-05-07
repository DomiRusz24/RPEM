package pl.alvion.rpem.rpessentials.magic.elemental.runedraw;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.utils.RayUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class RuneTable {

    private static ArrayList<RuneTable> runeTables = new ArrayList<>();
    private ArrayList<ParticleRay> particleRays = new ArrayList<>();
    ArrayList<Integer> moves = new ArrayList<>();

    public RunePoint[] runePoints = new RunePoint[49];

    private Player player;
    private int pid;
    private Location origin;
    private Location rayLocation;
    private Location rayLocation1;
    private static Location middle;

    public RuneTable(Player player) {
        RuneTable rT = this;
        this.player = player;
        origin = player.getLocation();
        if (player.getLocation().getPitch() > 30 || player.getLocation().getPitch() < -30) return;
        Location pLoc = player.getEyeLocation().add(0, 0.5, 0);
        World world = player.getWorld();
        double angle = Math.toRadians(pLoc.getYaw());
        Vector right = new Vector(-pLoc.getDirection().getZ() * 0.5, 0, pLoc.getDirection().getX() * 0.5);
        Vector left = new Vector(pLoc.getDirection().getZ() * 0.5, 0, -pLoc.getDirection().getX() * 0.5);
        Vector up = new Vector(0, 0.5, 0);
        Vector down = new Vector(0, -0.5, 0);
        Location first = pLoc.clone().add(-Math.sin(angle) * 3, 0, Math.cos(angle) * 3).add(left.clone().multiply(3)).add(up.clone().multiply(3));
        int d = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < 49; i++) {
            runePoints[i] = new RunePoint(first.clone().add(right.clone().multiply(r)).add(down.clone().multiply(d)), Color.GRAY);
            r++;
            c++;
            if (c % 7 == 0 && c != 0) {
                    d++;
                r = 0;
            }

        }
        middle = runePoints[24].location;
        runeTables.add(this);
        new BukkitRunnable() {
            @Override
            public void run() {
                pid = getTaskId();
                removeExistingTables(player, rT);
                if (rayLocation != null && rayLocation1 != null) {
                    particleRays.add(new ParticleRay(player.getWorld(), rayLocation, rayLocation1, Element.getSelectedElement(player).color));
                    rayLocation = null;
                    rayLocation1 = null;
                }
                for (int i = 0; i < 49; i++) {
                    if (runePoints[i] != null) {
                        if (rT.player.getLocation().distance(origin) > 7) {
                            this.cancel();
                            Bukkit.getScheduler().cancelTask(pid);
                            runeTables.remove(rT);
                        }
                        world.spawnParticle(Particle.REDSTONE, runePoints[i].location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(runePoints[i].color, 0.5f));
                    }
                }
                for (ParticleRay particleRay : particleRays) {
                    particleRay.createRay();
                }
            }
        }.runTaskTimer(RPEssentials.plugin, 0, 1);
    }


    private static void removeExistingTables(Player player, RuneTable rT) {
        for (Iterator<RuneTable> runeTableIterator = runeTables.iterator(); runeTableIterator.hasNext();) {
            RuneTable runeTable = runeTableIterator.next();
            if (runeTable.player.equals(player) && !runeTable.equals(rT)) {
                Bukkit.getScheduler().cancelTask(runeTable.pid);
                runeTableIterator.remove();
            }
        }
    }


    public static void rayTrackPoint(Player player) {
        ArrayList<Location> locations = RayUtils.getRayLocations(player, 10, 0.1);
        for (Location location : locations) {
            for (RuneTable runeTable : RuneTable.runeTables) {
                for (int i = 0; i < runeTable.runePoints.length; i++) {
                    if (runeTable.runePoints[i].location.distance(location) < 0.4) {
                        if (!runeTable.runePoints[i].runePointState.equals(RunePointState.DOUBLE)) {
                            Element element = Element.getSelectedElement(player);
                            runeTable.runePoints[i].color = element.color;
                            Element.playElementSound(player, element, element.f, element.f1);
                            runeTable.moves.add(i);
                            if (runeTable.rayLocation == null)
                                runeTable.rayLocation = runeTable.runePoints[i].location.clone();
                            else runeTable.rayLocation1 = runeTable.runePoints[i].location.clone();
                        }
                         if (runeTable.runePoints[i].runePointState.equals(RunePointState.INACTIVE)) runeTable.runePoints[i].runePointState = RunePointState.SINGLE;
                        else if (runeTable.runePoints[i].runePointState.equals(RunePointState.SINGLE)) runeTable.runePoints[i].runePointState = RunePointState.DOUBLE;
                        return;
                    }
                }
            }
        }
    }

    public static boolean getPlayerHasTable(Player player) {
        for (RuneTable runeTable : runeTables) {
            if (runeTable.player.equals(player)) return true;
        }
        return false;
    }

    public static RuneTable getPlayerTable(Player player) {
        for (RuneTable runeTable : runeTables) {
            if (runeTable.player.equals(player)) return runeTable;
        }
        return null;
    }

    public static void removePlayersTable(Player player) {
        Bukkit.getScheduler().cancelTask(getPlayerTable(player).pid);
        runeTables.removeIf(runeTable -> runeTable.player.equals(player));
    }

    public static void compareWithAllSymbols(RuneTable runeTable) {
        for (RuneSymbol runeSymbol : RuneSymbol.runeSymbols) {
            if (runeSymbol.compareWithTable(runeTable)) {
                if (runeSymbol.canDraw(runeTable.player)) runeSymbol.activate(runeTable.player, middle);
                return;
            }
        }
    }

    public ArrayList<ParticleRay> getRays() {
        return particleRays;
    }










}
