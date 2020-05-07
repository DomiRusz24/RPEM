package pl.alvion.rpem.rpessentials.magic.elemental.runedraw;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.utils.RayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public enum Element {
    UNIVERSAL(Color.GRAY, Sound.ENTITY_ENDER_EYE_DEATH, 0.3f, 2f),FIRE(Color.RED, Sound.BLOCK_FIRE_AMBIENT, 0.5f, 1f),AIR(Color.WHITE),WATER(Color.BLUE),EARTH(Color.GREEN);

    Element(Color color, Sound sound) {
        this.color = color;
        this.sound = sound;
    }

    Element(Color color, Sound sound, float f, float f1) {
        this.color = color;
        this.sound = sound;
        this.f = f;
        this.f1 = f1;
    }

    public Color color;
    public Sound sound;
    public float f;
    public  float f1;

    private static HashMap<Player, Element> playerSelectedElement = new HashMap<>();

    Element(Color color) {
        this.color = color;
    }

    public static void selectElement(Player player, Element element) {
        playerSelectedElement.put(player, element);
    }

    public static Element getSelectedElement(Player player) {
        if (playerSelectedElement.get(player) == null) return UNIVERSAL;
        return playerSelectedElement.get(player);
    }

    public static void playElementSound(Player player, Element element, float f, float f1) {
        player.playSound(player.getLocation(), element.sound, f, f1);
    }

    public static void playElementSound(Player player, Element element, float f, float f1, int ticks, int duration) {
        new BukkitRunnable() {
            int i = 0;
            public void run() {
                if (i > duration) Bukkit.getScheduler().cancelTask(getTaskId());
                player.playSound(player.getLocation(), element.sound, f, f1);
                i++;
            }
        }.runTaskTimer(RPEssentials.plugin, 0, ticks);

    }


}
