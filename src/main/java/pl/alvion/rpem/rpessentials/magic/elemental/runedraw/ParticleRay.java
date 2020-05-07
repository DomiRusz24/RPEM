package pl.alvion.rpem.rpessentials.magic.elemental.runedraw;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.utils.RayUtils;

import java.util.ArrayList;

public class ParticleRay {
    private Location loc1;
    private Location loc2;
    private Color color;
    private World world;
    public ParticleRay(World world, Location loc1, Location loc2, Color color) {
        this.loc1 = new Location(world, loc1.getX(), loc1.getY(), loc1.getZ());
        this.loc2 = new Location(world, loc2.getX(), loc2.getY(), loc2.getZ());
        this.color = color;
        this.world = world;
    }

    public ParticleRay(World world, Location loc1, Location loc2, Color color, Location middle) {
        this.loc1 = new Location(world, loc1.getX(), loc1.getY(), loc1.getZ());
        this.loc2 = new Location(world, loc2.getX(), loc2.getY(), loc2.getZ());
        this.color = color;
        this.world = world;
    }

    public void createRay() {
        ArrayList<Location> locations = RayUtils.getRayLocationsFromTo(loc1, loc2, 0.1);
        for (Location location : locations) {
            world.spawnParticle(Particle.REDSTONE, location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(color, 0.5f));
        }
    }

    public void createRay(double checkDistance) {
        ArrayList<Location> locations = RayUtils.getRayLocationsFromTo(loc1, loc2, 0.1, checkDistance);
        for (Location location : locations) {
            world.spawnParticle(Particle.REDSTONE, location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(color, 0.5f));
        }
    }

    public void createRay(int ticks, int duration) {
        ArrayList<Location> locations = RayUtils.getRayLocationsFromTo(loc1, loc2, 0.1);
        new BukkitRunnable() {
            int i = 0;
            public void run() {
                if (i > duration) Bukkit.getScheduler().cancelTask(getTaskId());
                for (Location location : locations) {
                    world.spawnParticle(Particle.REDSTONE, location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(color, 0.5f));
                }
                i++;
            }
        }.runTaskTimer(RPEssentials.plugin, 0, ticks);

    }

    public void createRay(int ticks, int duration, double checkDistance) {
        ArrayList<Location> locations = RayUtils.getRayLocationsFromTo(loc1, loc2, 0.1, checkDistance);
        new BukkitRunnable() {
            int i = 0;
            public void run() {
                if (i > duration) Bukkit.getScheduler().cancelTask(getTaskId());
                for (Location location : locations) {
                    world.spawnParticle(Particle.REDSTONE, location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(color, 0.5f));
                }
                i++;
            }
        }.runTaskTimer(RPEssentials.plugin, 0, ticks);

    }

    public void changeColor(Color color) {
        this.color = color;
    }

    public void toPlayer(Player player, Location middle) {
        Location oldLoc = loc1.clone();
        Location oldLoc1 = loc2.clone();

        Vector oldVectorToMiddle = oldLoc.toVector().subtract(middle.toVector());
        Vector oldVectorToMiddle1 = oldLoc1.toVector().subtract(middle.toVector());

        loc1.add(player.getEyeLocation().toVector().subtract(loc1.toVector()));
        loc2.add(player.getEyeLocation().toVector().subtract(loc2.toVector()));

        loc1.add(oldVectorToMiddle);
        loc2.add(oldVectorToMiddle1);

        loc1.add(player.getEyeLocation().getDirection().multiply(2));
        loc2.add(player.getEyeLocation().getDirection().multiply(2));
    }

    public void makeSmaller(Location middle) {
        Location oldLoc = loc1.clone();
        Location oldLoc1 = loc2.clone();
        Vector vector = oldLoc.toVector().subtract(middle.toVector()).multiply(-0.25);
        Vector vector1 = oldLoc1.toVector().subtract(middle.toVector()).multiply(-0.25);
        loc1.add(vector);
        loc2.add(vector1);
    }


}
