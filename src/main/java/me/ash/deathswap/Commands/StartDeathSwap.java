package me.ash.deathswap.Commands;

import me.ash.deathswap.DeathSwap;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class StartDeathSwap implements CommandExecutor {

    private final DeathSwap plugin;

    public StartDeathSwap(DeathSwap plugin) {
        this.plugin = plugin;
        plugin.getCommand("startDeathSwap").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Player p1 = player.getServer().getPlayer(args[0]);
        Player p2 = player.getServer().getPlayer(args[1]);
        BukkitScheduler sched = player.getServer().getScheduler();
        player.getServer().broadcastMessage(ChatColor.YELLOW + "Death Swap is has started");


        sched.scheduleSyncRepeatingTask(plugin, new Runnable() {//1s repeating task
            int cnt = 300;

            @Override
            public void run() {
                if (cnt == 240) {
                    player.sendMessage(ChatColor.RED + "4 minutes left");
                } else if (cnt == 180) {
                    player.sendMessage(ChatColor.RED + "3 minutes left");
                } else if (cnt == 120) {
                    player.sendMessage(ChatColor.RED + "2 minutes left");
                } else if (cnt == 60) {
                    player.sendMessage(ChatColor.RED + "1 minute left");
                } else if (cnt == 10) {
                    player.getServer().broadcastMessage(ChatColor.RED + "" + cnt + " Seconds left");
                } else if (cnt < 10 && cnt > 0) {
                    player.getServer().broadcastMessage(ChatColor.RED + "" + cnt);
                }
                cnt--;
                if (cnt == 0) {
                    player.getServer().broadcastMessage("Swap \nGood luck surviving your friends trap");
                    Location l1 = p1.getLocation();
                    Location l2 = p2.getLocation();
                    p1.teleport(l2);
                    p2.teleport(l1);
                    sched.cancelTasks(plugin);
                }
            }
        }, 0L, 20L);
        return true;
    }
}
