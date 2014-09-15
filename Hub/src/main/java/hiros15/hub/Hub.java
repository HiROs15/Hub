package hiros15.hub;

import hiros15.hub.Events.PlayerJoin;

import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {
	@Override
	public void onEnable() {
		setupEvents();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	//Setup Event
	public void setupEvents() {
		//When the player joins the server
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
	}
}
