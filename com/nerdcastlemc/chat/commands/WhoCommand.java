package com.nerdcastlemc.chat.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nerdcastlemc.NerdCastleChat;

public class WhoCommand implements CommandExecutor {
	NerdCastleChat ncc; 
	
	public WhoCommand(NerdCastleChat pl){
		ncc = pl; 
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("who")){
			sender.sendMessage("§e-------- §aPlayers §e---------"); 
			for(Player p : Bukkit.getOnlinePlayers()){
				Location l = p.getLocation(); 
				sender.sendMessage(p.getName() + " : " + p.getDisplayName() + " at " + l.getWorld().getName() + "("+ 
				l.getBlockX()+","+l.getBlockY() + ","+ l.getBlockZ() + ")");
			}
			
			return true; 
		}
		
		return false; 
	}
	
}
