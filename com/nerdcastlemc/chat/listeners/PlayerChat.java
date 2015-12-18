package com.nerdcastlemc.chat.listeners;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.nerdcastlemc.NerdCastleChat;

public class PlayerChat implements Listener {
	NerdCastleChat ncc; 
	
	public PlayerChat(NerdCastleChat pl){
		ncc = pl; 
	}
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent evt){
		evt.setMessage(ChatColor.translateAlternateColorCodes('&', evt.getMessage() ) ); 
	}
	
}
