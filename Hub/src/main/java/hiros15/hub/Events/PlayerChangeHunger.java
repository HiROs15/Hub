package hiros15.hub.Events;

import hiros15.hub.Api.JoinHubApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class PlayerChangeHunger implements Listener {
	private Plugin plugin;
	public PlayerChangeHunger(Plugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerHungerChange(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		JoinHubApi joinhubapi = new JoinHubApi(plugin);
		if(joinhubapi.checkForPlayerInHub(player)) {
			player.setFoodLevel(19);
		}
	}
}
