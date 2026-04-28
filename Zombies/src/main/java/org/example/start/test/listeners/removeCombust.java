package org.example.start.test.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class removeCombust implements Listener {

    //отменяем горение
    @EventHandler
    public void CancelBurn(EntityCombustEvent e) {
        if (e.getEntity().getType() == EntityType.ZOMBIE) {
            e.setCancelled(true);
        }
    }
}
