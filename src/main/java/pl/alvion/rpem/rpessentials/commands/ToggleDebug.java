package pl.alvion.rpem.rpessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.utils.names.Names;

import java.util.ArrayList;

public class ToggleDebug implements CommandExecutor {

    private static ArrayList<Player> players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("Musisz byc graczem zeby uzyc tej komendy!");
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("AlvionRP.ToggleDebug")) {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + " Niewystarczajace uprawnienia!");
            return false;
        }

        if (!players.contains(player)) {
            player.sendMessage(Names.getPrefix() + ChatColor.GREEN + " Wlaczono tryb debugowania!");
            players.add(player);
        }
        else {
            player.sendMessage(Names.getPrefix() + ChatColor.GREEN + " Wylaczono tryb debugowania!");
            players.remove(player);
        }


        return false;
    }

    public static boolean hasDebugModeEnabled(Player player) {
        return players.contains(player);
    }
}
