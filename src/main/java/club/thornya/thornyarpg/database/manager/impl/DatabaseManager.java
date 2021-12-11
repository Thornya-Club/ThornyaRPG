package club.thornya.thornyarpg.database.manager.impl;

import club.thornya.thornyarpg.ThornyaMain;
import club.thornya.thornyarpg.database.datasource.DataSource;
import club.thornya.thornyarpg.database.datasource.impl.MySQL;
import club.thornya.thornyarpg.database.datasource.impl.SQLite;
import club.thornya.thornyarpg.database.manager.ManagerService;
import lombok.val;
import org.bukkit.Bukkit;

import java.util.Objects;

public class DatabaseManager implements ManagerService {

    private ThornyaMain plugin;
    private DataSource dataSource;

    public DatabaseManager(ThornyaMain plugin){
        this.plugin = plugin;
        val section = plugin.getConfig().getConfigurationSection("Database");
        // optimize this
        val mode = Objects.requireNonNull(section).getString("Mode");

        switch(Objects.requireNonNull(mode).toLowerCase()) {
            case "mysql":
                //dataSource = new MySQL(plugin);
                break;
            case "sqlite":
                dataSource = new SQLite(plugin);
                break;
            default:
                Bukkit.getConsoleSender().sendMessage("§c[]§aThornyaRPG §eTipo de banco de dados errado. Reveja a config.yml");
                Bukkit.getConsoleSender().sendMessage("§c[]§aThornyaRPG §eDefinido automaticamente para SQLite.");
                dataSource = new SQLite(plugin);
                break;
        }
    }

    @Override
    public void load() {
        //users = new Users(plugin);
        //jobs = new Jobs(plugin);
        //organizations = new Organizations(plugin);

        //users.createTable();
        //jobs.createTable();
        //organizations.createTable();
    }

    @Override
    public void reload() {
        // Not used.
    }

    @Override
    public void unload() {
        dataSource.closeConnection();
    }

}
