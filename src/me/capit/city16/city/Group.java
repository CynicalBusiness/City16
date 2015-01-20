package me.capit.city16.city;

import java.util.ArrayList;
import java.util.List;

import me.capit.city16.city.fortification.FortificationModel;
import me.capit.city16.player.CityPlayer;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;

public class Group extends DataModel {
	private static final long serialVersionUID = 1729482110019256483L;
	
	private FortificationModel fortifications;
	
	public Group(String name){
		super(name);
		fortifications = new FortificationModel();
	}
	
	public Group(String name, CityPlayer... players){
		super(name, players);
	}
	
	@Override
	public void addChild(Child player){
		if (player instanceof CityPlayer) super.addChild(player);
	}
	
	@Override
	public CityPlayer findFirstChild(String name){
		return (CityPlayer) super.findFirstChild(name);
	}
	
	public List<CityPlayer> getPlayers(){
		List<CityPlayer> players = new ArrayList<CityPlayer>();
		for (Child c : getChildren()) if (c instanceof CityPlayer) players.add((CityPlayer) c);
		return players;
	}
	
	public FortificationModel getFortifications(){
		return fortifications;
	}
}
