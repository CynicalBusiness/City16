package me.capit.city16.city;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;

import me.capit.city16.CityPlugin;
import me.capit.city16.player.CityPlayer;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.value.ObjectValue;

public class Group extends DataModel {
	private static final long serialVersionUID = 1729482110019256483L;
	public String name;
	
	public Group(String name){
		super(name);
	}
	
	public List<CityPlayer> getPlayers(){
		List<CityPlayer> players = new ArrayList<CityPlayer>();
		for (UUID id : getPlayerIDs()) players.add(CityPlugin.getPlayer(id));
		return players;
	}
	
	public List<UUID> getPlayerIDs(){
		List<UUID> ids = new ArrayList<UUID>();
		for (Child child : getChildren()){
			if (child instanceof ObjectValue){
				@SuppressWarnings("unchecked") ObjectValue<UUID> player = (ObjectValue<UUID>) child;
				ids.add(player.getValue());
			}
		}
		return ids;
	}
	
	public void addPlayer(CityPlayer player){
		addPlayer(player.playerID);
	}
	
	public void addPlayer(UUID player){
		addChild(new ObjectValue<UUID>("player", player));
	}
	
	public void removePlayer(UUID player){
		
	}
}
