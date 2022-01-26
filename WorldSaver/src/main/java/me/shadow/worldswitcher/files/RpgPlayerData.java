package me.shadow.worldswitcher.files;

import me.shadow.worldswitcher.WorldSwitcher;
import me.shadow.worldswitcher.storagemanagment.StorageManager;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class RpgPlayerData extends AbstractFile
{
    StorageManager storageManager;
    public RpgPlayerData(WorldSwitcher main, StorageManager storageManager)
    {
        super(main, "rpgplayerdata.yml");
        this.storageManager = storageManager;
    }


    public void saveInfo()
    {
        System.out.println("Saving Info Into File");


        for (Map.Entry<String, ItemStack[]> entry : storageManager.rpgInventoryContents.entrySet())
        {
            this.getConfig().set("invdata." + entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : storageManager.rpgLevel.entrySet())
        {
            Integer value = entry.getValue();
            if (value == null) value = 0;
            this.getConfig().set("lvl." + entry.getKey(), value);
        }
        for (Map.Entry<String, Float> entry : storageManager.rpgEXP.entrySet())
        {
            Float value = entry.getValue();
            if (value == null) value = 0f;
            this.getConfig().set("exp." + entry.getKey(), value);
        }
        for (Map.Entry<String, ItemStack[]> entry : storageManager.rpgEnderchest.entrySet())
        {
            this.getConfig().set("echest." + entry.getKey(), entry.getValue());
        }
        this.saveConfig();
    }

    public void loadInfo()
    {
        this.getConfig().getConfigurationSection("invdata").getKeys(false).forEach(key ->
        {
            ItemStack[] content = ((List<ItemStack>) this.getConfig().get("invdata." + key)).toArray(new ItemStack[0]);
            storageManager.rpgInventoryContents.put(key, content);
        });

        this.getConfig().getConfigurationSection("lvl").getKeys(false).forEach(key ->
        {
            Integer level = (Integer) this.getConfig().get("lvl." + key);
            storageManager.rpgLevel.put(key,level);
        });

        this.getConfig().getConfigurationSection("exp").getKeys(false).forEach(key ->
        {
            Float exp = (Float) this.getConfig().get("exp." + key);
            storageManager.rpgEXP.put(key, exp);
        });

        this.getConfig().getConfigurationSection("echest").getKeys(false).forEach(key ->
        {
            ItemStack[] content = ((List<ItemStack>) this.getConfig().get("echest." + key)).toArray(new ItemStack[0]);
            storageManager.rpgEnderchest.put(key, content);
        });
    }
}
