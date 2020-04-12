package pl.alvion.rpem.rpessentials;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayerListener;

import java.io.File;
import java.io.IOException;

public final class RPEssentials extends JavaPlugin {

    public static File RPPlayerData;
    public static FileConfiguration RPPlayerDataConfig;
    private static JavaPlugin instance;
    
    @Override
    public void onEnable() {
        System.out.println("AlvionRP core zostalo uruchomione");
        Bukkit.getPluginManager().registerEvents(new RPPlayerListener(), this);
        instance = this;

    }

    @Override
    public void onDisable() {
        System.out.println("AlvionRP core zostalo wylaczone");
    }

    public static FileConfiguration getRPPlayerDataConfig() {
        return RPPlayerDataConfig;
    }

    private void createRPPlayerDataConfig() {
        RPPlayerData = new File(getDataFolder(), "RPPlayerData.yml");
        if (!RPPlayerData.exists()) {
            RPPlayerData.getParentFile().mkdirs();
            saveResource("RPPlayerData.yml", false);
        }

        RPPlayerDataConfig= new YamlConfiguration();
        try {
            RPPlayerDataConfig.load(RPPlayerData);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveRPPlayerConfig() {
        try {
            RPPlayerDataConfig.save(RPPlayerData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
