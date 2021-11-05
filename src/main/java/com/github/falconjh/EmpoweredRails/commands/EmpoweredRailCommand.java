package com.github.falconjh.EmpoweredRails.commands;

import com.github.falconjh.EmpoweredRails.config.EmpoweredRailsConfig;
import com.github.falconjh.EmpoweredRails.config.GsonUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.Block;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import com.github.falconjh.EmpoweredRails.EmpoweredRails;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

import static com.github.falconjh.EmpoweredRails.EmpoweredRails.config;
import static com.github.falconjh.EmpoweredRails.EmpoweredRails.configpath;

public class EmpoweredRailCommand {
    private  EmpoweredRailCommand(){}
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(CommandManager.literal("empoweredrail").requires((source)-> source.hasPermissionLevel(2))
                .then(CommandManager.literal("set")
                    .then(CommandManager.argument("block", BlockStateArgumentType.blockState())
                        .then(CommandManager.argument("speed", DoubleArgumentType.doubleArg(0.0, 30.0))
                            .executes(EmpoweredRailCommand::SetSpeed)
                        )
                    )
                )
                .then(CommandManager.literal("save")
                        .executes(EmpoweredRailCommand::Save)
                )
                .then(CommandManager.literal("reload")
                        .executes(EmpoweredRailCommand::Reload)
                )
        );
    }

    private static int SetSpeed(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        Block b = BlockStateArgumentType.getBlockState(context, "block").getBlockState().getBlock();
        String blockid =  b.getLootTableId().toString();

        blockid = blockid.replace("blocks/","");
        double speed = DoubleArgumentType.getDouble(context, "speed");
        config.blocks.put(blockid,speed);
        return Command.SINGLE_SUCCESS;
    }

    private static int Save(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        if(GsonUtil.writeFile(configpath, config))
        {
            source.sendFeedback(new LiteralText("Saved config"), true);
            return Command.SINGLE_SUCCESS;
        }
        return -1;
    }

    private static int Reload(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        try {
            config = GsonUtil.getcreateConfigFile(configpath, config, EmpoweredRailsConfig.class);
            source.sendFeedback(new LiteralText("Reloaded config!"), true);
            return Command.SINGLE_SUCCESS;
        }catch(Exception e){
            source.sendFeedback(new LiteralText("Failed to reload config").formatted(Formatting.RED), true);
            return -1;
        }
    }
}
