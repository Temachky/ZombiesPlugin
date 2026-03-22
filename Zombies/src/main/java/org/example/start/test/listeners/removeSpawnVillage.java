package org.example.start.test.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.AsyncStructureSpawnEvent;
import org.bukkit.generator.structure.Structure;

public class removeSpawnVillage implements Listener {

    @EventHandler
    public void WhenVillageSpawn(AsyncStructureSpawnEvent e) {
        if(e.getStructure() == Structure.VILLAGE_PLAINS) {
            e.setCancelled(true);
        }
    }
}
