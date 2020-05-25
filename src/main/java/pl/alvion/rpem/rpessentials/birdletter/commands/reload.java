package pl.alvion.rpem.rpessentials.birdletter.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.birdletter.file.BLData;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (strings[0].equalsIgnoreCase("reload-data") && p.hasPermission("BirdLetterReload")) {
            BLData.reload();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5[&dBirdLetter&5] &bPrzeładowano BLData.yml"));
        }else { p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5[&dBirdLetter&5] &cNie masz dostępu do tej komendy.")); }
        return false;
    }
}
