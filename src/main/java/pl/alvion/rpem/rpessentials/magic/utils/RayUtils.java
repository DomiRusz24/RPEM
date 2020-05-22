package pl.alvion.rpem.rpessentials.magic.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class RayUtils {

    public static ArrayList<Location> getRayLocations(Player player, double distance, double multiplier) {
        ArrayList<Location> locations = new ArrayList<>();
        Location origin = player.getEyeLocation();
        Vector addition = player.getLocation().getDirection().multiply(multiplier);
        Location start = player.getEyeLocation().add(addition);
        locations.add(start);
        while (start.distance(origin) < distance) {
            locations.add(start.add(addition).clone());
        }
        return locations;
    }

    public static ArrayList<Location> getRayLocationsFromTo(Location loc1, Location loc2, double multiplier) {
        ArrayList<Location> locations = new ArrayList<>();
        Location l1 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY(), loc1.getZ());
        Location l2 = new Location(loc2.getWorld(), loc2.getX(), loc2.getY(), loc2.getZ());
        Vector vector = l2.toVector().subtract(l1.toVector()).multiply(multiplier);
        if (l1.distance(l2) == 0) locations.add(l1);
        while (l1.distance(l2) > 0.05) {
           locations.add(l1.clone());
           l1.add(vector);
        }
        return locations;
    }

    public static ArrayList<Location> getRayLocationsFromTo(Location loc1, Location loc2, double multiplier, double checkDistance) {
        ArrayList<Location> locations = new ArrayList<>();
        Location l1 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY(), loc1.getZ());
        Location l2 = new Location(loc2.getWorld(), loc2.getX(), loc2.getY(), loc2.getZ());
        Vector vector = l2.toVector().subtract(l1.toVector()).multiply(multiplier);
        if (l1.distance(l2) == 0) locations.add(l1);
        while (l1.distance(l2) > checkDistance) {
            locations.add(l1.clone());
            l1.add(vector);
        }
        return locations;
    }


    public static Location getTargetedLocation(Player player, double distance, double multiplier) {
        Location origin = player.getEyeLocation();
        Vector addition = player.getLocation().getDirection().multiply(multiplier);
        Location start = player.getEyeLocation().add(addition);
        while (start.distance(origin) < distance && (start.getBlock().getType().equals(Material.AIR))) {
            start.add(addition);
        }
        return start;
    }

    public static Location getTargetedLocationOrEntity(Player player, double distance, double multiplier, double entityDistance) {
        Location origin = player.getEyeLocation();
        Vector addition = player.getLocation().getDirection().multiply(multiplier);
        Location start = player.getEyeLocation().add(addition);
        while (start.distance(origin) < distance && (start.getBlock().getType().equals(Material.AIR)) && !getLocationContainsLivingEntity(player, start, entityDistance)) {
            start.add(addition);
        }
        return start;
    }

    private static boolean getLocationContainsLivingEntity(Player player, Location location, double distance) {
        for (Entity entity : player.getWorld().getNearbyEntities(location, distance, distance, distance)) {
            if (entity instanceof LivingEntity && !entity.equals(player)) return true;
        }

        return false;
    }


    public static ArrayList<Material> transparentMaterials = new ArrayList<>(Arrays.asList(Material.GRASS, Material.TALL_GRASS, Material.LADDER, Material.WATER, Material.AIR));

    public static Location getTargetedLocation(Player player, double distance, double multiplier, ArrayList<Material> pass) {
        Location origin = player.getEyeLocation();
        Vector addition = player.getLocation().getDirection().multiply(multiplier);
        Location start = player.getEyeLocation().add(addition);
        while (start.distance(origin) < distance && pass.contains(start.getBlock().getType())) {
            start.add(addition);
        }
        return start;
    }

    public static Location getTargetedLocationOrEntity(Player player, double distance, double multiplier,  ArrayList<Material> pass, double entityDistance) {
        Location origin = player.getEyeLocation();
        Vector addition = player.getLocation().getDirection().multiply(multiplier);
        Location start = player.getEyeLocation().add(addition);
        while (start.distance(origin) < distance && pass.contains(start.getBlock().getType()) && !getLocationContainsLivingEntity(player, start, entityDistance)) {
            start.add(addition);
        }
        return start;
    }
}
