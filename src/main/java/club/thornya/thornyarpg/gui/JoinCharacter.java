package club.thornya.thornyarpg.gui;

import dev.triumphteam.gui.guis.Gui;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinCharacter {

    public static void chooseCharacter(Player p){

        Gui GUIChooseCharacter = Gui.gui()
                .title(Component.text(PlaceholderAPI.setPlaceholders(p,"§c%multilang_choosechar%")))
                .rows(6)
                .create();
        GUIChooseCharacter.setDefaultClickAction(event -> {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
                return;
            if (event.isShiftClick() && event.isLeftClick() || event.isLeftClick() || event.isRightClick()) {
                event.setCancelled(true);
            }
            if (event.getCursor() != null) {
                event.setCancelled(true);
            }
        });

        GUIChooseCharacter.open(p);

    }

}
