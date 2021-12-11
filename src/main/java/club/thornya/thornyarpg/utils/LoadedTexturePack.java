package club.thornya.thornyarpg.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import java.util.ArrayList;

public class LoadedTexturePack implements Listener {

    public static ArrayList<String> PlayerWithTexture = new ArrayList<>();

    @EventHandler
    public void onResourcepackStatusEvent(PlayerResourcePackStatusEvent event){
        if(event.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED || event.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
            PlayerWithTexture.remove(event.getPlayer().getName());
        }
        if(event.getStatus() == PlayerResourcePackStatusEvent.Status.ACCEPTED){
            PlayerWithTexture.add(event.getPlayer().getName());
        }

    }

}
