package pl.alvion.rpem.rpessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.customcrafting_dr.custom_crafting_guis.GownianyStolik;
import pl.alvion.rpem.rpessentials.generalutils.gui.GUI;
import pl.alvion.rpem.rpessentials.generalutils.gui.guis.RandomStats;
import pl.alvion.rpem.rpessentials.generalutils.names.Names;

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
            return false;
        }

        if(strings.length == 2) {
            switch (strings[1]) {
                case "0":
                    GUI gui = new RandomStats();
                    gui.open(player);
                    break;
                case "1":
                    GownianyStolik gui1 = new GownianyStolik(player);
                    gui1.openInv(true);
                    break;
                default:
                    player.sendMessage(Names.getPrefix() + ChatColor.RED + "Takie ID nie istnieje!");
            }
        } else {
            player.sendMessage(Names.getPrefix() + ChatColor.RED + "Podano wiecej lub mniej niz 2 argumenty!");
        }
        return false;
    }
}
