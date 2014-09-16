package hiros15.hub.Commands;

import hiros15.Messages.Messages;
import hiros15.Messages.hubMenu;
import hiros15.hub.Api.HubDataApi;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {
	private Plugin plugin;
	public Commands(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			plugin.getLogger().log(Level.WARNING,"Please do not use console to execute any hub commands.");
			return false;
		}
		//Player instance
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("hub")) {
			if(!player.hasPermission("hub.info")) {
				player.sendMessage(Messages.noperms);
				return false;
			}
			if(args.length == 0) {
				hubMenu hubmenu = new hubMenu();
				hubmenu.displayHubMenu(player);
				return false;
			}
			if(args[0].equalsIgnoreCase("sethub")) {
				if(!player.hasPermission("hub.admin.sethub")) {
					player.sendMessage(Messages.noperms);
					return false;
				}
				HubDataApi hubdataapi = new HubDataApi(plugin);
				hubdataapi.setHub(player);
				return false;
			}
		}
		return false;
	}
}
