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
class DonateCommand {
    @CommandDescription("Shows a link to support the server")
    @CommandMethod("donate")
    @Suppress("unused")
    fun donateCommand(sender: CommandSender) {

        if (sender !is Player) {
            val noPlayerMsg = Component.text("This command can only be ran by players.")
            sender.sendMessage(noPlayerMsg)
        }

        val donateMessage = Component.text("Click to Donate to the Server", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://nearvanilla.buycraft.net/"))

        sender.sendMessage(donateMessage)
        return
    }
}