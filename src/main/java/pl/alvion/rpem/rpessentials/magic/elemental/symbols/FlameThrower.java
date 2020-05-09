package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.elemental.listeners.ElementalListener;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.Element;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.ParticleRay;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneSymbol;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneTable;

import java.util.ArrayList;
import java.util.Arrays;

public class FlameThrower extends RuneSymbol {

    @Override
    public boolean canDraw(Player player) {
        return Element.getSelectedElement(player).equals(Element.FIRE);

    }

    @Override
    public void activate(Player player, Location middle) {
        ArrayList<ParticleRay> particleRays = RuneTable.getParticleRaysFromRuneTable(player, moves(), 3);
        for (ParticleRay particleRay : particleRays) {
            particleRay.toPlayer(player, middle);
            particleRay.makeSmaller(middle);
            Element.playElementSound(player, Element.FIRE, 0.1f, 1.5f, 6, 8);
            particleRay.createRay(1, 5, 0.03);
        }
        ElementalListener.setNextSneakEvent(player, () -> {nextActivate(player, middle, particleRays);});
    }

    private void nextActivate(Player player, Location middle, ArrayList<ParticleRay> particleRays) {
        for (ParticleRay particleRay : particleRays) {
            particleRay.toPlayer(player, middle);
            particleRay.makeSmaller(middle);
            Element.playElementSound(player, Element.FIRE, 0.1f, 1.5f, 6, 8);
            particleRay.createRay(1, 20, 0.03);
        }
        ElementalListener.setNextSneakEvent(player, () -> {nextActivate(player, middle);});
    }

    private void nextActivate(Player player, Location middle) {
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i > 40 || !player.isSneaking()) Bukkit.getScheduler().cancelTask(getTaskId());
                spawnFlame(player, player.getEyeLocation());
                i++;
            }
        }.runTaskTimer(RPEssentials.plugin, 0, 2);

        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i > 16 || !player.isSneaking()) Bukkit.getScheduler().cancelTask(getTaskId());
                RuneTable runeTable = new RuneTable(player, moves(), 1.7);
                ArrayList<ParticleRay> particleRays = runeTable.getRays();
                for (ParticleRay particleRay : particleRays) {
                    particleRay.makeSmaller(runeTable.getMiddle());
                    Element.playElementSound(player, Element.FIRE, 0.1f, 1.5f, 6, 8);
                    particleRay.createRay(1, 3, 0.05);
                }
                i++;
            }
        }.runTaskTimer(RPEssentials.plugin, 0,6);
    }


    private void spawnFlame(Player player, Location origin) {
        new BukkitRunnable() {
            Location projectile = origin.clone().add(player.getEyeLocation().getDirection());
            World world = player.getWorld();
            @Override
            public void run() {
                if (projectile.distance(origin) > 14 || projectile.getBlock().getType().isSolid()) Bukkit.getScheduler().cancelTask(getTaskId());
                projectile.add(origin.getDirection().multiply(0.5));
                world.spawnParticle(Particle.FLAME, projectile, 1, 0.3, 0.3, 0.3, 0.0001);
                if (projectile.getBlock().getType().equals(Material.AIR)) projectile.getBlock().setType(Material.FIRE);
                for (Entity entity : world.getNearbyEntities(projectile, 0.5, 0.5, 0.5)) {
                    if (entity instanceof LivingEntity && !entity.equals(player)) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.setFireTicks(60);
                        livingEntity.damage(1, player);
                    }
                }
            }
        }.runTaskTimer(RPEssentials.plugin, 0, 1);
    }

    @Override
    public ArrayList<Integer> moves() {
        return new ArrayList<>(Arrays.asList(38,22,22,10,10,26,26,31,31,17));
    }
}
