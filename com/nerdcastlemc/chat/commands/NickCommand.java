package com.nerdcastlemc.chat.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nerdcastlemc.NerdCastleChat;

public class NickCommand implements CommandExecutor {
	NerdCastleChat ncc; 
	
	public NickCommand(NerdCastleChat pl){
		ncc = pl; 
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("nick")){
			if(args.length >= 1){
				String newName = ""; 
				
				for(int i = 0; i <= args.length-1; i++){
					newName += args[i]; 
				}
				
				newName = ChatColor.translateAlternateColorCodes('&', newName); 
				newName += ChatColor.RESET; 
				
				Bukkit.getLogger().info("Name: " + newName); 
				if(sender instanceof Player){
					Player p = (Player) sender; 
					p.setDisplayName(newName); //Should save this... 
					p.sendMessage("Your name has been set to: " + newName);
					ncc.getConfig().set(p.getUniqueId()+"", newName);
					ncc.saveConfig(); //OOOWWW
					return true; 
				}else {
					sender.sendMessage("Seriously Nate? You're console. You don't have a name."); 
					return true; 
				}
				
			} else {
				sender.sendMessage("Please include what you want your nickname to be. - Nate");
				return true; 
			}
		}
		
		return false; 
	}
	
}
