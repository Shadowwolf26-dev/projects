package me.shadow.worldswitcher.storagemanagment;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerInfo
{
    private String name;
    private ItemStack[] inventory;
    private int level;
    private float exp;
    private UUID uuid;

    public PlayerInfo(ItemStack[] inventoryContents, int level, float exp)
    {
        this.inventory = inventoryContents;
        this.level = level;
        this.exp = exp;
    }

    public PlayerInfo(Player player)
    {
        this.name = player.getName();
        this.inventory = player.getInventory().getContents();
        this.level = player.getLevel();
        this.exp = player.getExp();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
