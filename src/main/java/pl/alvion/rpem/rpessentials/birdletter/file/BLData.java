package pl.alvion.rpem.rpessentials.birdletter.file;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BLData {
    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("RPEssentials").getDataFolder(), "BirdLetter/BLData.yml");

        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e) {}
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() { return config; }

    public static void save() {
        try {
            config.save(file);
        }catch (IOException e) {}
    }

    public static void reload() { config = YamlConfiguration.loadConfiguration(file); }
}