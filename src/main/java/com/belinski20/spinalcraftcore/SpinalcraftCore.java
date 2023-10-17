package com.belinski20.spinalcraftcore;

import com.belinski20.spinalcraftcore.messages.ComponentMessages;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SpinalcraftCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ComponentMessages.makeMessage("SpinalcraftCore Loaded!", NamedTextColor.AQUA));
    }

}
