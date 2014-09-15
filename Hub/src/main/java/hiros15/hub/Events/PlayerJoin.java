package hiros15.hub.Events;

import hiros15.hub.Api.JoinHubApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
	@SuppressWarnings("unused")
	private Plugin plugin;
	public PlayerJoin(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		@SuppressWarnings("unused")
		JoinHubApi joinhubapi = new JoinHubApi();
		@SuppressWarnings("unused")
		Player player = event.getPlayer();
		event.setJoinMessage("");
	}
}
