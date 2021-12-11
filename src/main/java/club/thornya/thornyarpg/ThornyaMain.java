package club.thornya.thornyarpg;

import club.thornya.thornyarpg.users.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ThornyaMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§e+==========================+");
        Bukkit.getConsoleSender().sendMessage("§c[]§aThornyaRPG ligando!");
        Bukkit.getConsoleSender().sendMessage("§e+==========================+");
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            registrarComandos();
            registrarListener(new PlayerJoin());
        } else {
            Bukkit.getConsoleSender().sendMessage("§c[]§aThornyaRPG " + "Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("Carregando");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Desligando");
    }

    public void registrarComandos(){
        registrarComando("test", new UnitTest());
        //Objects.requireNonNull(getCommand("template")).setTabCompleter(new TabPrefeitura(this));
    }

    public void registrarComando(String nome, CommandExecutor comando) {
        Objects.requireNonNull(this.getCommand(nome)).setExecutor(comando);
    }

    public void registrarListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

}