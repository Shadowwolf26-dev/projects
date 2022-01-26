package me.shadow.worldswitcher.storagemanagment;

import me.shadow.worldswitcher.WorldSwitcher;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageManager
{
    public Map<String, ItemStack[]> overworldEnderchest = new HashMap<>();
    public Map<String, ItemStack[]> rpgEnderchest = new HashMap<>();

    public Map<String, ItemStack[]> overworldInventoryContents = new HashMap<>();
    public Map<String, ItemStack[]> rpgInventoryContents = new HashMap<>();

    public Map<String, Integer> overworldLevel = new HashMap<>();
    public Map<String, Integer> rpgLevel = new HashMap<>();

    public Map<String, Float> overworldEXP = new HashMap<>();
    public Map<String, Float> rpgEXP = new HashMap<>();

    public void switchToOverworld(Player player)
    {
        rpgEnderchest.put(player.getUniqueId().toString(), player.getEnderChest().getContents());
        rpgInventoryContents.put(player.getUniqueId().toString(), player.getInventory().getContents());
        rpgLevel.put(player.getUniqueId().toString(), player.getLevel());
        rpgEXP.put(player.getUniqueId().toString(), player.getExp());

        if (overworldInventoryContents.containsKey(player.getUniqueId().toString()))
        {
            player.getInventory().setContents(overworldInventoryContents.get(player.getUniqueId().toString()));
            if (overworldLevel.get(player.getUniqueId().toString()) == null) player.setLevel(0);
            else player.setLevel(overworldLevel.get(player.getUniqueId().toString()));

            if (overworldEXP.get(player.getUniqueId().toString()) == null) player.setExp(0);
            else player.setExp(overworldEXP.get(player.getUniqueId().toString()));

            if (overworldEnderchest.containsKey(player.getUniqueId().toString()))
                player.getEnderChest().setContents(overworldEnderchest.get(player.getUniqueId().toString()));
            else
            {
                ItemStack[] empty = {};
                player.getEnderChest().setContents(empty);
            }
        }
        else
        {
            ItemStack[] empty = {};
            player.getInventory().setContents(empty);
            player.setLevel(0);
            player.setExp(0);
        }
    }

    public void switchToRpgWorld(Player player)
    {
        overworldEnderchest.put(player.getUniqueId().toString(), player.getEnderChest().getContents());
        overworldInventoryContents.put(player.getUniqueId().toString(), player.getInventory().getContents());
        overworldLevel.put(player.getUniqueId().toString(), player.getLevel());
        overworldEXP.put(player.getUniqueId().toString(), player.getExp());

        if (rpgInventoryContents.containsKey(player.getUniqueId().toString()))
        {
            player.getEnderChest().setContents(rpgEnderchest.get(player.getUniqueId().toString()));
            player.getInventory().setContents(rpgInventoryContents.get(player.getUniqueId().toString()));
            player.setLevel(rpgLevel.get(player.getUniqueId().toString()));
            player.setExp(rpgEXP.get(player.getUniqueId().toString()));
        }
        else
        {
            ItemStack[] empty = {};
            player.getInventory().setContents(empty);
            player.getEnderChest().setContents(empty);
            player.setLevel(0);
            player.setExp(0);
        }

    }

}
