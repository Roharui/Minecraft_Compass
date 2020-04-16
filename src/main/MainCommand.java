package main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("This Command is for only Player");
			return false;
		}
		
		Player player = (Player) sender;
		if (args.length > 0) {
			
		}
		else {
			player.sendMessage("You Should Enter the Player's name");
		}
		return true;
	}

}
