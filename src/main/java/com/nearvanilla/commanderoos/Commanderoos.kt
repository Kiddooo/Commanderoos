package com.nearvanilla.commanderoos

import cloud.commandframework.annotations.AnnotationParser
import cloud.commandframework.arguments.parser.ParserParameters
import cloud.commandframework.arguments.parser.StandardParameters
import cloud.commandframework.execution.CommandExecutionCoordinator
import cloud.commandframework.meta.CommandMeta
import cloud.commandframework.paper.PaperCommandManager
import com.nearvanilla.commanderoos.commands.*
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import java.util.function.Function
import java.util.logging.Logger

class Commanderoos : JavaPlugin() {
    companion object{
        lateinit var pluginLogger: Logger
            private set
    }

    private lateinit var commandManager: PaperCommandManager<CommandSender>
    private lateinit var annotationParser: AnnotationParser<CommandSender>
    private lateinit var commandMetaFunction: Function<ParserParameters, CommandMeta>

    override fun onEnable() {
        pluginLogger = logger

        commandManager = PaperCommandManager(
            this,
            CommandExecutionCoordinator.simpleCoordinator(),
            Function.identity(),
            Function.identity(),
        )

        commandMetaFunction =
            Function<ParserParameters, CommandMeta> { p: ParserParameters ->
                CommandMeta.simple() // This will allow you to decorate commands with descriptions
                    .with(
                        CommandMeta.DESCRIPTION,
                        p.get(StandardParameters.DESCRIPTION, "No description"),
                    )
                    .build()
            }
        annotationParser = AnnotationParser(
            commandManager,
            CommandSender::class.java,
            commandMetaFunction,
        )
        annotationParser.parse(AwardsCommand())
        annotationParser.parse(DonateCommand())
        annotationParser.parse(FarmCommand())
        annotationParser.parse(MapCommand())
        annotationParser.parse(ShopCommand())
        annotationParser.parse(TunnelCommand())
        annotationParser.parse(WebsiteCommand())


        logger.info("Commands enabled idk")
    }

    override fun onDisable() {
        logger.info("Commands shutdown sad")
    }
}
