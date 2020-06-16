package me.christo;

import me.christo.Listener.VoidEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Creation of Config
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists())
            saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new VoidEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
