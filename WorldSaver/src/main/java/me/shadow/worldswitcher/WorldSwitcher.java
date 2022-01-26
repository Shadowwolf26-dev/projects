package me.shadow.worldswitcher;

import me.shadow.worldswitcher.commands.SwitchDimensionCommand;
import me.shadow.worldswitcher.commands.SwitchDimensionCommandAutoComplete;
import me.shadow.worldswitcher.files.OverworldPlayerData;
import me.shadow.worldswitcher.files.RpgPlayerData;
import me.shadow.worldswitcher.storagemanagment.PlayerInfo;
import me.shadow.worldswitcher.storagemanagment.StorageManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class WorldSwitcher extends JavaPlugin {

    public static StorageManager storageManager = new StorageManager();

    private OverworldPlayerData overworldPlayerData;
    private RpgPlayerData rpgPlayerData;

    @Override
    public void onEnable()
    {
        this.getCommand("worldswitch").setExecutor(new SwitchDimensionCommand(this));
        this.getCommand("worldswitch").setTabCompleter(new SwitchDimensionCommandAutoComplete());

        if (!getDataFolder().exists())
        {
            getDataFolder().mkdir();
        }

        this.overworldPlayerData = new OverworldPlayerData(this, storageManager);
        this.rpgPlayerData = new RpgPlayerData(this, storageManager);

        if (overworldPlayerData.getConfig().contains("invdata"))
        {
            overworldPlayerData.loadInfo();
            System.out.println("Loading Info From File");
        }
        if (rpgPlayerData.getConfig().contains("invdata"))
        {
            rpgPlayerData.loadInfo();
            System.out.println("Loading Info From File");
        }

    }

    @Override
    public void onDisable()
    {
        if (!storageManager.overworldInventoryContents.isEmpty())
            overworldPlayerData.saveInfo();
        if (!storageManager.rpgInventoryContents.isEmpty())
            rpgPlayerData.saveInfo();
    }

    public void saveInfo()
    {
        overworldPlayerData.saveInfo();
        rpgPlayerData.saveInfo();
    }

}
