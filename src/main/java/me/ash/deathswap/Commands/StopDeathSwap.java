package me.ash.deathswap.Commands;

import me.ash.deathswap.DeathSwap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopDeathSwap implements CommandExecutor {

    private final DeathSwap plugin;

    public StopDeathSwap(DeathSwap plugin) {
        this.plugin = plugin;
        plugin.getCommand("stopDeathSwap").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        p.getServer().broadcastMessage("Stopping Death Swap manually");
        p.getServer().getScheduler().cancelTasks(this.plugin);

        return true;
    }
}
