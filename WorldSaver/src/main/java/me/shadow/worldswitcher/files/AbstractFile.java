package me.shadow.worldswitcher.files;

import me.shadow.worldswitcher.WorldSwitcher;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class AbstractFile
{
    protected WorldSwitcher main;
    private File file;
    protected FileConfiguration config;

    public AbstractFile(WorldSwitcher main, String fileName)
    {
        this.main = main;
        this.file = new File(main.getDataFolder(), fileName);
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void saveConfig()
    {
        try {
            config.save(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig()
    {
        return config;
    }
}
