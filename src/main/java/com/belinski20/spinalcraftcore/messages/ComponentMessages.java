package com.belinski20.spinalcraftcore.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class ComponentMessages {

    public static TextComponent makeMessage(String message)
    {
        return Component.text().content(message).build();
    }

    public static TextComponent makeMessage(String message, NamedTextColor color)
    {
        return Component.text().content(message).color(color).build();
    }

    public static TextComponent makeMessage(String message, NamedTextColor color, TextDecoration decoration, boolean hasDecoration)
    {
        return Component.text().content(message).color(color).decoration(decoration, hasDecoration).build();
    }

}
