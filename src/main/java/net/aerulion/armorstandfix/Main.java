package net.aerulion.armorstandfix;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onEntitySpawn(final EntityAddToWorldEvent event) {
    if (event.getEntityType() == EntityType.ARMOR_STAND
        && event.getEntity() instanceof ArmorStand armorStand) {
      armorStand.setCanTick(armorStand.hasBasePlate());
    }
  }
}