package hiros15.hub.HubScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardApi {
	private Plugin plugin;
	public ScoreboardApi(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void setScoreboard(Player player) {
		final String[] ani = {
				ChatColor.BOLD+""+ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"THE SAKURA NETWORK",
				ChatColor.RED+""+ChatColor.BOLD+"THE SAKURA NETWORK",
				ChatColor.YELLOW+""+ChatColor.BOLD+"THE SAKURA NETWORK",
				ChatColor.GREEN+""+ChatColor.BOLD+"THE SAKURA NETWORK",
				ChatColor.GOLD+""+ChatColor.BOLD+"THE SAKURA NETWORK",
				ChatColor.BLUE+""+ChatColor.BOLD+"THE SAKURA NETWORK"
		};
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		final Objective objective = board.registerNewObjective("test","dummy");
		
		objective.setDisplayName(ChatColor.BOLD+""+ChatColor.LIGHT_PURPLE+"THE SAKURA NETWORK");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score s1 = objective.getScore(ChatColor.GREEN+""+ChatColor.BOLD+"Sakura Coins");
		s1.setScore(1);
		
		Score s2 = objective.getScore(ChatColor.WHITE+"0");
		s2.setScore(1);
		
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int index = 0;
			public void run() {
				if(index == ani.length){
					index = 0;
				}
				objective.setDisplayName(ani[index]);
				index++;
			}
		}, 10L, 10L);
		player.setScoreboard(board);
	}
}
