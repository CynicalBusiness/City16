package me.capit.city16.player;

import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CityPlayer implements Serializable {
	private static final long serialVersionUID = 4903589010093251584L;
	
	public final UUID playerID;
	private int power;
	
	public CityPlayer(Player player){
		playerID = player.getUniqueId();
	}
	
	public Player getPlayer(){
		return Bukkit.getServer().getPlayer(playerID);
	}
	
	public int getPower(){
		return power;
	}
}
