package hiros15.hub.Events;

import hiros15.hub.Api.JoinHubApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDamagePlayer implements Listener {
	private Plugin plugin;
	public PlayerDamagePlayer(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		JoinHubApi joinhubapi = new JoinHubApi(plugin);
		Player player = (Player) event.getEntity();
		if(joinhubapi.checkForPlayerInHub(player)) {
			event.setCancelled(true);
		}
	}
}
