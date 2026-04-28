package org.example.start.test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class SumZom implements Runnable{

    int min = 0;
    int[] coordinates = {20, 25, -25, -20};
    int max = coordinates.length - 1;


    //спавним зомби каждые 90 сек возле игрока. Зомби может быть прокаченным либо обычный
    @Override
    public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
        boolean IsSpawn = false;

        //устанавливаем локацию спавна
        World world = player.getWorld();
        Location lock = player.getLocation().add(coordinates[Random()], 0, coordinates[Random()]);
         lock.setY(lock.getWorld().getHighestBlockYAt(lock) + 1);

        //вызываем функцию рандома если результат равен 20 то спавним крутого зомби
         if (RandomForStrongZombie() == 20) {
             Zombie zomb = (Zombie) world.spawnEntity(lock, EntityType.ZOMBIE);
             zomb.setBaby(false);
             zomb.getAttribute(Attribute.ATTACK_DAMAGE).setBaseValue(6);
             zomb.getAttribute(Attribute.MAX_HEALTH).setBaseValue(40);
             zomb.setHealth(40);
             IsSpawn = true;
         }

        //если результат равен не 20 то спавним обычного зомби
           else {
               Zombie zomb = (Zombie) world.spawnEntity(lock, EntityType.ZOMBIE);
        zomb.setBaby(false);
        IsSpawn = true;
           }
        //прерываем цикл если зомби заспавнился
           if(IsSpawn) {
               break;
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