package hiros15.hub.Events;

import hiros15.hub.Api.JoinHubApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class PlayerBreakBlockEvent implements Listener {
	private Plugin plugin;
	public PlayerBreakBlockEvent(Plugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerBreakBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
		JoinHubApi joinhubapi = new JoinHubApi(plugin);
		if(joinhubapi.checkForPlayerInHub(player)) {
			event.setCancelled(true);
			player.sendMessage("");
		} else {
			return;
		}
	}
}
