package com.nerdcastlemc;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.nerdcastlemc.chat.commands.ChatCommand;
import com.nerdcastlemc.chat.commands.NickCommand;
import com.nerdcastlemc.chat.commands.WhoCommand;
import com.nerdcastlemc.chat.listeners.PlayerChat;
import com.nerdcastlemc.chat.listeners.PlayerLogin;

public class NerdCastleChat extends JavaPlugin{
	@Override
	public void onEnable(){
		
		Bukkit.getLogger().info("Nateb1121's NerdCastleChat has been endabled");
		getCommand("nick").setExecutor(new NickCommand(this));
		getCommand("chat").setExecutor(new ChatCommand(this)); 
		getCommand("who").setExecutor(new WhoCommand(this));
		
		registerListeners(new PlayerLogin(this), new PlayerChat(this)); 
		
		if (!new File(getDataFolder(), "config.yml").exists()) {
		      saveDefaultConfig();
		      getLogger().warning("The default config has been generated. If you need, please change it.");
		}
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
	private void registerListeners(Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getPluginManager().registerEvents(listener, this);
		}
	}
}
