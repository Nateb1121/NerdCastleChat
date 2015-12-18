package com.nerdcastlemc.chat.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nerdcastlemc.NerdCastleChat;

public class ChatCommand implements CommandExecutor {
	NerdCastleChat ncc; 
	
	public ChatCommand(NerdCastleChat pl){
		ncc = pl; 
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("chat")){
			if(args.length >= 1){
				if(sender instanceof Player){
					Player p = (Player)sender;
					p.setDisplayName(p.getDisplayName() + ChatColor.translateAlternateColorCodes('&', args[0]));
					p.sendMessage("Your chat color has been set to" +  ChatColor.translateAlternateColorCodes('&', args[0]) + " this color.");
				}
			} else {
				sender.sendMessage("Please include what you want your chat color to be. - Nate");
				return true; 
			}
		}
		
		return false; 
	}
	
}
