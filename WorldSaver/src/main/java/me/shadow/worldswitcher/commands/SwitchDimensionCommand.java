package me.shadow.worldswitcher.commands;

import me.shadow.worldswitcher.WorldSwitcher;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwitchDimensionCommand implements CommandExecutor
{
    WorldSwitcher main;

    public SwitchDimensionCommand(WorldSwitcher main)
    {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            String dimensionSelected = args[0];

            switch (dimensionSelected)
            {
                case "NormalWorld":
                    World world = p.getServer().getWorld("world");
                    Location location = world.getSpawnLocation();
                    p.teleport(location);
                    WorldSwitcher.storageManager.switchToOverworld(p);
                    main.saveInfo();
                    break;
                case "RawfallRpg":
                    World world2 = p.getServer().getWorld("world_shadow_dungeon");
                    Location location2 = world2.getSpawnLocation();
                    p.teleport(location2);
                    WorldSwitcher.storageManager.switchToRpgWorld(p);
                    main.saveInfo();
                    break;
                default:
                    p.sendMessage(ChatColor.DARK_RED + "Please select an existent world");
            }
            return true;
        }
        return true;
    }
}
