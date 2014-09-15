package hiros15.hub.Api;

import java.util.ArrayList;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class JoinHubApi {
	private Plugin plugin;
	public JoinHubApi(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public ArrayList<UUID> hubPlayers = new ArrayList<UUID>();
	
	/*
	 * This is the join message. Remember to change this here!
	 * In the future remember to try to implement this into a configuration file for easier access.
	 */
	public void joinMessage(Player player) {
		//No message as of now.
		player.sendMessage("");
	}
	
	public void joinHub(Player player) {
		//add to array
		hubPlayers.add(player.getUniqueId());
		
		HubDataApi hubdataapi = new HubDataApi(plugin);
		if(hubdataapi.getHubSetup() == false) {
			player.sendMessage(ChatColor.RED+"There is no hub currently setup.");
			return;
		}
		teleportPlayerToHub(player);
	}
	
	public void teleportPlayerToHub(Player player) {
		HubDataApi hubdataapi = new HubDataApi(plugin);
		player.teleport(hubdataapi.getHubData());
	}
}
