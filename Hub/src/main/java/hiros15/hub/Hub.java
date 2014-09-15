package hiros15.hub;

import hiros15.hub.Config.HubConfig;
import hiros15.hub.Events.PlayerJoin;

import org.bukkit.plugin.java.JavaPlugin;


/*
 * This code is Copyright by HiROs15 or Kyle Staschke.
 * All rights to this code are reserved.
 * Sakura members share the rights to the server and all its content and possible revenue generated.
 * No possible funds shall be taken by a member of sakura without everyone in the groups consent.
 */

public class Hub extends JavaPlugin {
	@Override
	public void onEnable() {
		setupEvents();
		setupConfigFiles();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	//Setup Event
	public void setupEvents() {
		//When the player joins the server
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
	}
	
	public void setupConfigFiles() {
		HubConfig hubconfig = new HubConfig(this);
		hubconfig.getConfig().set("setup", true);
		hubconfig.saveConfig();
	}
}
