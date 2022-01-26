package me.shadow.worldswitcher.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwitchDimensionCommandAutoComplete implements TabCompleter
{
    private String[] COMMANDS =
            {"NormalWorld", "RawfallRpg"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
    {
        final List<String> completions = new ArrayList<>();

        StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);

        Collections.sort(completions);
        return completions;
    }
}
