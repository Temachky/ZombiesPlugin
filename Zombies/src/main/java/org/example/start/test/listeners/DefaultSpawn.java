package org.example.start.test.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import java.util.ArrayList;
import java.util.List;

public class DefaultSpawn implements Listener {

    ArrayList<EntityType> entities = new ArrayList<EntityType>(List.of(
            EntityType.ZOMBIE,
            EntityType.COW,
            EntityType.SHEEP,
            EntityType.CHICKEN,
            EntityType.PIG
            ));


    ArrayList<EntityType> entitiForComplete = new ArrayList<EntityType>(List.of(
            EntityType.ENDER_DRAGON,
            EntityType.END_CRYSTAL,
            EntityType.TNT,
            EntityType.TNT_MINECART,
            EntityType.BLAZE,
            EntityType.ENDERMAN
    ));

    @EventHandler
    public void Zombieses(CreatureSpawnEvent e) {

        World world = e.getEntity().getWorld();

        if (!entities.contains(e.getEntity().getType()) & !entitiForComplete.contains(e.getEntity().getType())) {
            e.setCancelled(true);
            return;
        }
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.COMMAND || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM) {
            return;
        }

         if (e.getEntity().getType() == EntityType.ZOMBIE) {
                 List<Player> players = e.getEntity().getWorld().getPlayers();
                 boolean isSpawn = false;
                 if(!players.isEmpty()) {
                     for(Player player : players) {
                         int mobes = player.getNearbyEntities(20, 20, 20).size();
                         if (mobes <= 50) {
                             for (int i = 1; i <= 2; i++) {
                                 Spawn(e, world);
                                 isSpawn = true;
                                }
                         }
                         if (isSpawn) break;
                     }
             }
         } else if (entities.contains(e.getEntity().getType())) {
             Spawn(e, world);
         }

        }

        public void Spawn(CreatureSpawnEvent e, World world) {
            Location lock = e.getEntity().getLocation().add(Random(), 0, Random());
            int y = e.getEntity().getWorld().getHighestBlockYAt(lock) + 1;
            lock.setY(y);
            world.spawnEntity(lock, e.getEntity().getType());
        }

    public int Random() {
        int random = (int) (Math.random() * (15 - -10 + 1)) + -10;
        return random;
    }
}