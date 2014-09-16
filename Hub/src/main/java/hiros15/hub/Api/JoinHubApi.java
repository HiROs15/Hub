package hiros15.hub.Api;

import hiros15.hub.Data.HubData;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinHubApi {
	private Plugin plugin;
	public JoinHubApi(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean checkForPlayerInHub(Player player) {
		if(HubData.hubPlayers.contains(player.getUniqueId())) {
			return true;
		} else {
			return false;
		}
	}
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
		HubData.hubPlayers.add(player.getUniqueId());
		
		HubDataApi hubdataapi = new HubDataApi(plugin);
		if(hubdataapi.getHubSetup() == false) {
			player.sendMessage(ChatColor.RED+"There is no hub currently setup.");
			return;
		}
		teleportPlayerToHub(player);
		setupPlayerEffects(player);
	}
	
	public void teleportPlayerToHub(Player player) {
		HubDataApi hubdataapi = new HubDataApi(plugin);
		player.teleport(hubdataapi.getHubData());
	}
	
	public void setupPlayerEffects(Player player) {
		player.setGameMode(GameMode.ADVENTURE);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 3));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999999, 5));
	}
}
