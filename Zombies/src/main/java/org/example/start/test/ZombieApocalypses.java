package org.example.start.test;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.example.start.test.listeners.removeSpawnVillage;
import org.example.start.test.listeners.DefaultSpawn;
import org.example.start.test.listeners.removeCombust;

public final class ZombieApocalypses extends JavaPlugin implements Listener {
   BukkitTask SummonZombie;

    @Override
    public void onEnable() {
        getServer().getLogger().info("сервер запущен");
        getServer().getPluginManager().registerEvents(new DefaultSpawn(), this);
        getServer().getPluginManager().registerEvents(new removeCombust(), this);
        getServer().getPluginManager().registerEvents(new removeSpawnVillage(), this);


        SummonZombie = getServer().getScheduler().runTaskTimer(this, new SumZom(), 60 * 20, 30 * 20 );

    }
    @Override
    public void onDisable() {
        SummonZombie.cancel();

    }
}
