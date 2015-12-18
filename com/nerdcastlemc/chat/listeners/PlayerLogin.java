package com.nerdcastlemc.chat.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nerdcastlemc.NerdCastleChat;

public class PlayerLogin implements Listener {
	NerdCastleChat ncc; 
	
	public PlayerLogin(NerdCastleChat pl){
		ncc = pl; 
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent evt){
		String uuid = evt.getPlayer().getUniqueId() + ""; 
		String newName = ncc.getConfig().getString(uuid); 
		Bukkit.getLogger().info("Loaded " + evt.getPlayer().getName() + " with " + uuid + " and name " + newName); 
		
		if(newName == ""){
		} else {
			evt.getPlayer().setDisplayName(newName);
		}
		
	}
	
}
