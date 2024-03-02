package me.ash.deathswap;

import me.ash.deathswap.Commands.StartDeathSwap;
import me.ash.deathswap.Commands.StopDeathSwap;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathSwap extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin DeathSwap has started.");
        new StartDeathSwap(this);
        new StopDeathSwap(this);

    }

    @Override
    public void onDisable() {
        System.out.println("Plugin DeathSwap has stopped.");
    }
}
