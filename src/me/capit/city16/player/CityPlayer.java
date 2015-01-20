package me.capit.city16.player;

import java.util.UUID;

import me.capit.city16.city.Group;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.Parent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CityPlayer implements Child {
	private static final long serialVersionUID = 4903589010093251584L;
	
	private final UUID playerID;
	private Group parent;
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

	@Override
	public String getName() {
		return getPlayer().getName();
	}

	@Override
	public UUID getUniqueID() {
		return playerID;
	}

	@Override
	public void setName(String name) {
		// Nothing
	}

	@Override
	public Group getParent() {
		return parent;
	}

	@Override
	public void setParent(Parent parent) {
		if (parent instanceof Group) this.parent = (Group) parent;
	}
	
	public boolean isInCity(){
		return parent!=null;
	}
}
