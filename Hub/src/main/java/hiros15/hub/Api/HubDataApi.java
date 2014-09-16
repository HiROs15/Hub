package hiros15.hub.Api;

import hiros15.hub.Config.HubConfig;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HubDataApi {
	private Plugin plugin;
	public HubDataApi(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public Location getHubData() {
		HubConfig hubconfig = new HubConfig(plugin);
		Location loc = new Location(
				Bukkit.getServer().getWorld(hubconfig.getConfig().getString("hub.spawn.world")),
				hubconfig.getConfig().getDouble("hub.spawn.x"),
				hubconfig.getConfig().getDouble("hub.spawn.y"),
				hubconfig.getConfig().getDouble("hub.spawn.z"),
				(float) hubconfig.getConfig().getDouble("hub.spawn.pitch"),
				(float) hubconfig.getConfig().getDouble("hub.spawn.yaw")
				);
		return loc;
	}
	
	public boolean getHubSetup() {
		HubConfig hubconfig = new HubConfig(plugin);
		if(hubconfig.getConfig().getBoolean("hub.spawn.setup") == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setHub(Player player) {
		Location loc = player.getLocation();
		HubConfig hubconfig = new HubConfig(plugin);
		
		hubconfig.getConfig().set("hub.spawn.world", loc.getWorld().getName());
		hubconfig.getConfig().set("hub.spawn.x", loc.getX());
		hubconfig.getConfig().set("hub.spawn.y", loc.getY());
		hubconfig.getConfig().set("hub.spawn.z", loc.getZ());
		hubconfig.getConfig().set("hub.spawn.pitch", loc.getPitch());
		hubconfig.getConfig().set("hub.spawn.yaw", loc.getYaw());
		hubconfig.getConfig().set("hub.spawn.setup", true);
		hubconfig.saveConfig();
		
		player.sendMessage(ChatColor.GREEN+"Hub spawn location has been set. Players should now join.");
	}
}
