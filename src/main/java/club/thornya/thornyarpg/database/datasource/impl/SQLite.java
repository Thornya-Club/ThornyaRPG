package club.thornya.thornyarpg.database.datasource.impl;

import club.thornya.thornyarpg.ThornyaMain;
import club.thornya.thornyarpg.database.datasource.DataSource;

import lombok.val;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite implements DataSource {

    private ThornyaMain plugin;

    private String url;

    public SQLite(ThornyaMain plugin) {
        this.plugin = plugin;

        val file = new File(plugin.getDataFolder(), "database.db");
        this.url = "jdbc:sqlite:" + file;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public void closeConnection() {
        // Not used.
    }

}
