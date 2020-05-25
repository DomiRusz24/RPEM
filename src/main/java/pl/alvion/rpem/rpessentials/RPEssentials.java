package pl.alvion.rpem.rpessentials;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pl.alvion.rpem.rpessentials.commands.RandomStatsCommand;
import pl.alvion.rpem.rpessentials.commands.ResetRandomizedStats;
import pl.alvion.rpem.rpessentials.commands.ToggleDebug;
import pl.alvion.rpem.rpessentials.magic.elemental.listeners.ElementalListener;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayerListener;
import pl.alvion.rpem.rpessentials.rpplayer.traits.Trait;
import pl.alvion.rpem.rpessentials.rpplayer.traits.TraitsListener;
import pl.alvion.rpem.rpessentials.utils.gui.GUIListener;

import java.io.File;
import java.io.IOException;

public final class RPEssentials extends JavaPlugin {

    public static File RPPlayerData;
    public static FileConfiguration RPPlayerDataConfig;
    public static JavaPlugin plugin;
    
    @Override
    public void onEnable() {
        System.out.println("AlvionRP core zostalo uruchomione");
        createRPPlayerDataConfig();
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new RPPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new TraitsListener(), this);
        Bukkit.getPluginManager().registerEvents(new ElementalListener(), this);
        Bukkit.getPluginCommand("RandomStats").setExecutor(new RandomStatsCommand());
        Bukkit.getPluginCommand("ToggleDebug").setExecutor(new ToggleDebug());
        Bukkit.getPluginCommand("ResetRandomizedStats").setExecutor(new ResetRandomizedStats());
        Trait.loadTraitsByChanceArray();

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
        try {
            if (RPPlayerData.createNewFile()) {
                try {
                    RPPlayerData.getParentFile().createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
