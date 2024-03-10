package com.nearvanilla.commanderoos.commands

import cloud.commandframework.annotations.CommandDescription
import cloud.commandframework.annotations.CommandMethod
import cloud.commandframework.annotations.processing.CommandContainer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@CommandContainer
class MapCommand {
    @CommandDescription("Shows a link to the dynmap/bluemap")
    @CommandMethod("map|dynmap|bluemap")
    @Suppress("unused")
    fun mapCommand(sender: CommandSender) {

        if (sender !is Player) {
            val noPlayerMsg = Component.text("This command can only be ran by players.")
            sender.sendMessage(noPlayerMsg)
        }

        val survivalMessage = Component.text("Click for the Survival Dynmap", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://map.nearvanilla.com/"))

        val creativeMessage = Component.text("Click for the Creative Map", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://bluemap.nearvanilla.com/"))

        sender.sendMessage(survivalMessage)
        sender.sendMessage(creativeMessage)

        return
    }
}
