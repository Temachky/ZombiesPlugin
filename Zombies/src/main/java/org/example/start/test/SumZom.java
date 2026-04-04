package org.example.start.test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

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
         int IsStrong = RandomForStrongZombie();
         if (IsStrong == 20) {
             Zombie zomb = (Zombie) world.spawnEntity(lock, EntityType.ZOMBIE);
             zomb.setBaby(false);
             zomb.getAttribute(Attribute.ATTACK_DAMAGE).setBaseValue(6);
             zomb.getAttribute(Attribute.MAX_HEALTH).setBaseValue(40);
             zomb.setHealth(40);
         }
           else {
               Zombie zomb = (Zombie) world.spawnEntity(lock, EntityType.ZOMBIE);
        zomb.setBaby(false);
           }
       }
    }

    public int Random() {
      int random = (int) (Math.random() * (max - min + 1)) + min;
      return random;
    }

    public int RandomForStrongZombie() {
     int random = (int) (Math.random() * (coordinates[0] - min + 1)) + min;
     return random;
    }
}