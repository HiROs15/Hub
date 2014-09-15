package hiros15.hub.Events;

import hiros15.hub.Api.JoinHubApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
	private Plugin plugin;
	public PlayerJoin(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		JoinHubApi joinhubapi = new JoinHubApi(plugin);
		Player player = event.getPlayer();
		event.setJoinMessage("");
		
		//Call from api
		joinhubapi.joinMessage(player);
		joinhubapi.joinHub(player);
	}
}
