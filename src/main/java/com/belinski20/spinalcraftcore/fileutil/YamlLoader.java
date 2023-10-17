package com.belinski20.spinalcraftcore.fileutil;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class YamlLoader {

    private Plugin plugin;

    public YamlLoader(Plugin plugin)
    {
        this.plugin = plugin;
    }

    /**
     * Creates the folders for the plugin
     * @param folders The names of the folders you want to create
     */
    public void createPluginDirectories(String... folders)
    {
        for(String folder : folders)
        {
            String fullPath = plugin.getDataFolder() + File.separator + folder;
            File file = new File(fullPath);
            file.mkdir();
        }
    }

    /**
     * Creates a file for a plugin
     * @param path The path from the data folder to where the file is expected to be
     * @param fileName The name of the file you are looking for ???.yml
     * @param KeyValuePairs The list of all values you want to save.
     */
    public boolean createPluginFile(String path, String fileName, YamlKeyValue[] KeyValuePairs)
    {
        String fullPath = plugin.getDataFolder() + File.separator + path;
        FileConfiguration config;
        File file = new File(fullPath, fileName);
        try {
            if(file.createNewFile())
            {
                config = YamlConfiguration.loadConfiguration(file);
                for(YamlKeyValue pair : KeyValuePairs)
                {
                    config.set(pair.getPath(), pair.getValue());
                }
                config.save(file);
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Saves the file for a plugin
     * @param path The path from the data folder to where the file is expected to be
     * @param fileName The name of the file you are looking for ???.yml
     * @param KeyValuePairs The list of all values you want to save.
     * @return
     */
    public boolean savePluginFile(String path, String fileName, YamlKeyValue[] KeyValuePairs)
    {
        String fullPath = plugin.getDataFolder() + File.separator + path;
        FileConfiguration config;
        File file = new File(fullPath, fileName);
        try {
            if(file.exists())
            {
                config = YamlConfiguration.loadConfiguration(file);
                for(YamlKeyValue pair : KeyValuePairs)
                {
                    config.set(pair.getPath(), pair.getValue());
                }
                config.save(file);
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Loads a file for a plugin
     * @param path The path from the data folder to where the file is expected to be
     * @param fileName The name of the file you are looking for ???.yml
     * @return
     */
    public YamlKeyValue[] loadPluginFile(String path, String fileName)
    {
        String fullPath = plugin.getDataFolder() + File.separator + path;
        YamlKeyValue[] keyValuePair = null;
        Stack yamlStack = new Stack();

        FileConfiguration config;
        File file = new File(fullPath, fileName);
        if(file.exists())
        {
            config = YamlConfiguration.loadConfiguration(file);
            for(String sect : config.getKeys(true))
                yamlStack.push(sect);
            keyValuePair = new YamlKeyValue[yamlStack.size()];
            int i = 0;
            while(!yamlStack.isEmpty())
            {
                String sectionPath = (String)yamlStack.pop();
                keyValuePair[i] = new YamlKeyValue(sectionPath, config.get(sectionPath));
                i++;
            }
        }
        return keyValuePair;
    }

    /**
     * Gets a specific value from the provided file
     * @param path The path from the data folder to where the file is expected to be
     * @param fileName The name of the file you are looking for ???.yml
     * @param valuePath The path where the value is located
     * @return
     */
    public Object getConfigValue(String path, String fileName, String valuePath)
    {
        String fullPath = plugin.getDataFolder() + File.separator + path;
        FileConfiguration config;
        File file = new File(fullPath, fileName);
        if(file.exists())
        {
            config = YamlConfiguration.loadConfiguration(file);
            return config.get(valuePath);
        }
        return null;
    }
}
