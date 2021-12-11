package club.thornya.thornyarpg.users.listeners;

import club.thornya.thornyarpg.gui.JoinCharacter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        JoinCharacter.chooseCharacter(event.getPlayer());
    }

}
