package org.example.start.test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SumZom implements Runnable{
    World world = Bukkit.getWorld("test for plugin");
    int min = 0;
    int[] coordinates = {20, 25, -25, -20};
    int max = coordinates.length;



    @Override
    public void run() {

    for (Player player : Bukkit.getOnlinePlayers()) {
        Location lock = player.getLocation().add(coordinates[Random()], 0, coordinates[Random()]);
        int y = lock.getWorld().getHighestBlockYAt(lock) + 1;
         lock.setY(y);

        world.spawnEntity(lock, EntityType.ZOMBIE);
       }
    }

    public int Random() {
      int random = (int) (Math.random() * (max - min + 1)) + min;
      return random;
    }
}
