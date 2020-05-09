package pl.alvion.rpem.rpessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.utils.gui.GUI;
import pl.alvion.rpem.rpessentials.utils.gui.guis.stats.RandomStats;
import pl.alvion.rpem.rpessentials.utils.names.Names;

public class GeneralDebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) {
            System.out.println("Musisz byc graczem zeby uzyc tej komendy!");
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("AlvionRP.GDC")) {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + " Niewystarczajace uprawnienia!");
        }

        GUI gui = new RandomStats();
        gui.open(player);


        return false;
    }
}
