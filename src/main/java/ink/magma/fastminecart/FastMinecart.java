package ink.magma.fastminecart;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitLamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class FastMinecart extends JavaPlugin implements Listener {
    public static SpeedManager speedManager;
    public static FastMinecart instance;

    public Collection<UUID> debugPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        saveDefaultConfig();
        speedManager = new SpeedManager(this);

        // events
        Bukkit.getPluginManager().registerEvents(new VehicleEventListener(), this);

        // commands

        var lamp = BukkitLamp.builder(this).build();
        lamp.register(new MainCommand());

        getLogger().info("插件已正常载入.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
