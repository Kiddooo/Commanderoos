package com.nearvanilla.commanderoos.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AwardsCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        if (sender !is Player) {
            val noPlayerMsg = Component.text("This command can only be ran by players.")
            sender.sendMessage(noPlayerMsg)
        }

        val awardsMessage = Component.text("Click to view Player Statistics", NamedTextColor.DARK_AQUA, TextDecoration.ITALIC).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, "https://nearvanilla.com/stats"))

        sender.sendMessage(awardsMessage)
        return true
    }
}