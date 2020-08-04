package me.msyial.motd;

import org.bukkit.ChatColor;
        import org.bukkit.Server;
        import org.bukkit.configuration.file.FileConfiguration;
        import org.bukkit.configuration.file.FileConfigurationOptions;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.server.ServerListPingEvent;
        import org.bukkit.plugin.PluginManager;
        import org.bukkit.plugin.java.JavaPlugin;

public class MsyialMotd extends JavaPlugin implements Listener {
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().addDefault("Motd.Line1", "&6MsyialMotd");
        getConfig().addDefault("Motd.Line2", "&eChange it in the config.yml");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @EventHandler
    public void onServerPing(ServerListPingEvent e)
    {
        e.setMotd(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Motd.Line1") + "\n" + getConfig().getString("Motd.Line2")));
    }
}
