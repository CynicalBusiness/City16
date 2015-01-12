package me.capit.city16.player;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class CityPlayer implements Serializable {
	private static final long serialVersionUID = 4903589010093251584L;
	
	public final UUID playerID;
	private int power;
	
	public CityPlayer(OfflinePlayer player){
		playerID = player.getUniqueId();
	}
	
	public OfflinePlayer getPlayer(){
		return Bukkit.getServer().getOfflinePlayer(playerID);
	}
	
	public int getPower(){
		return power;
	}
}
