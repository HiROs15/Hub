package hiros15.hub.Config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class HubConfig {
	private Plugin plugin;
	private FileConfiguration config;
	private File file;
	
	public HubConfig(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void reloadConfig() {
		if(file == null) {
			file = new File(plugin.getDataFolder(), "hub.yml");
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig() {
		if(config == null) {
			reloadConfig();
		}
		return config;
	}
	
	public void saveConfig() {
		if(file == null) {
			reloadConfig();
		}
		try {
			config.save(file);
 		} catch(Exception e) {}
	}
}
