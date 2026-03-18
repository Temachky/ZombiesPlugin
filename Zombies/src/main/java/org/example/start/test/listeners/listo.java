package org.example.start.test.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class listo implements Listener {

    ArrayList<EntityType> entities = new ArrayList<EntityType>(List.of(
            EntityType.ZOMBIE,
            EntityType.COW,
            EntityType.SHEEP,
            EntityType.CHICKEN,
            EntityType.PIG
            ));


    @EventHandler
    public void Zombieses(CreatureSpawnEvent e) {
         if (e.getEntity().getType() == EntityType.ZOMBIE) {
             Player player = e.getEntity().getWorld().getPlayers().stream().toList().getFirst();
             int mobes = Array.getLength(player.getNearbyEntities(50, 50, 50));
             if (mobes <= 50) {
                 World world = e.getEntity().getWorld();
                 Location lock = e.getEntity().getLocation().add(10, 0, 10);
                 int y = e.getEntity().getWorld().getHighestBlockYAt(lock);
                 y = y + 1;
                 lock.setY(y);
                 world.spawnEntity(lock, EntityType.ZOMBIE);
             }
         }
    }

    @EventHandler
    public void SpawnNeZombie(CreatureSpawnEvent e) {
         if (!entities.contains(e.getEntity().getType())) {
             e.setCancelled(true);
         }
    }
}
