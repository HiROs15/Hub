package hiros15.Messages;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class hubMenu {
	public void displayHubMenu(Player player) {
		player.sendMessage(ChatColor.YELLOW+"---------------"+ChatColor.WHITE+"Sakura Network Hub"+ChatColor.YELLOW+"---------------");
		player.sendMessage(ChatColor.GRAY+"This code was developed by HiROs15.");
		player.sendMessage("");
		player.sendMessage(ChatColor.GOLD+"/hub sethub "+ChatColor.WHITE+"Setup the hub spawn.");
	}
}
