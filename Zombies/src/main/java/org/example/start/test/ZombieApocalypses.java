package org.example.start.test;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.start.test.listeners.listo;

public final class ZombieApocalypses extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new listo(), this);
    }
    @Override
    public void onDisable() {

    }
}
