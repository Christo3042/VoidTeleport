package me.christo.Listener;

import me.christo.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Copy Right ©
 * This code is private
 * Owner: Christo
 * From: 10/22/19-2023
 * Any attempts to use these program(s) may result in a penalty of up to $1,000 USD
 **/

public class VoidEvent implements Listener {

    private final Main main;

    public VoidEvent(Main main) {
        this.main = main;

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent e) {
        if (e.getTo().getBlockY() > main.getConfig().getInt("yPosition", -5)) {
            return;
        }
            String l = main.getConfig().getString("teleport-location");
            String[] loc = l.split(";");
            Location location = e.getPlayer().getLocation();
            if (main.getConfig().getStringList("disabledWorlds") != null &&
                    main.getConfig().getStringList("disabledWorlds").contains(location.getWorld().getName()))
                return;
            location.setWorld(Bukkit.getWorld(loc[0]));
            location.setX(Double.parseDouble(loc[1]));
            location.setY(Double.parseDouble(loc[2]));
            location.setZ(Double.parseDouble(loc[3]));
            location.setYaw((float)Double.parseDouble(loc[4]));
            location.setPitch((float)Double.parseDouble(loc[5]));
            e.getPlayer().teleport(location);
            e.getPlayer().setFallDistance(0.0F);
        }
    //lol

}
