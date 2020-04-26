package pl.alvion.rpem.rpessentials;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pl.alvion.rpem.rpessentials.commands.GeneralDebugCommand;
import pl.alvion.rpem.rpessentials.rpplayer_dr.traits.TraitsListener;
import pl.alvion.rpem.rpessentials.utils.gui.GUIListener;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayerListener;

import java.io.File;
import java.io.IOException;

public final class RPEssentials extends JavaPlugin {

    public static File RPPlayerData;
    public static FileConfiguration RPPlayerDataConfig;
    public static JavaPlugin plugin;
    
    @Override
    public void onEnable() {
        System.out.println("AlvionRP core zostalo uruchomione");
        //createRPPlayerDataConfig();
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new RPPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new TraitsListener(), this);
        Bukkit.getPluginCommand("GDC").setExecutor(new GeneralDebugCommand());

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
}
