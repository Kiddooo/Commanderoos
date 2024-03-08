package com.nearvanilla.commanderoos.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class WebsiteCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        if (sender !is Player) {
            val noPlayerMsg = Component.text("This command can only be ran by players.")
            sender.sendMessage(noPlayerMsg)
        }

        val websiteMessage = Component.text("Click to visit our Website", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://nearvanilla.com/"))

        sender.sendMessage(websiteMessage)
        return true
    }
}