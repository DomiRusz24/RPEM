package pl.alvion.rpem.rpessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.utils.gui.guis.stats.RandomStats;
import pl.alvion.rpem.rpessentials.utils.names.Names;

public class ResetRandomizedStats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("Musisz byc graczem zeby uzyc tej komendy!");
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("AlvionRP.ResetRandomizedStats")) {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + " Niewystarczajace uprawnienia!");
            return false;
        }

        if (args.length == 0) {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + " Wprowadz nazwe gracza!");
            return false;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + " Ten gracz nie jest online!");
            return false;
        }
        RandomStats.resetRolledStats(player);
        player.sendMessage(Names.getPrefix() + ChatColor.GREEN + " Zresetowano wylosowane statystyki gracza " + args[0] + "!");

        return false;
    }
}
