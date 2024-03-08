package com.nearvanilla.commanderoos

import com.nearvanilla.commanderoos.commands.*
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class Commanderoos : JavaPlugin() {
    companion object{
        lateinit var pluginLogger: Logger
            private set
    }

    override fun onEnable() {
        pluginLogger = logger

        this.getCommand("map")?.setExecutor(MapCommand())
        this.getCommand("farm")?.setExecutor(FarmCommand())
        this.getCommand("shop")?.setExecutor(ShopCommand())
        this.getCommand("tunnel")?.setExecutor(TunnelCommand())
        this.getCommand("awards")?.setExecutor(AwardsCommand())
        this.getCommand("donate")?.setExecutor(DonateCommand())
        this.getCommand("website")?.setExecutor(WebsiteCommand())

        logger.info("Started lol")
    }

    override fun onDisable() {
        logger.info("Shutdown lol")
    }
}
