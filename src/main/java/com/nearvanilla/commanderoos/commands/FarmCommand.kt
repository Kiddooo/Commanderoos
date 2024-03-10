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
class FarmCommand {
    @CommandDescription("Shows a link to the public farm directory")
    @CommandMethod("farm|farms")
    @Suppress("unused")
    fun farmCommand(sender: CommandSender) {

        if (sender !is Player) {
            val noPlayerMsg = Component.text("This command can only be ran by players.")
            sender.sendMessage(noPlayerMsg)
        }

        val farmMessage = Component.text("Click for the Public Farm Directory", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://noto.li/m6CxWY"))

        sender.sendMessage(farmMessage)
        return
    }
}