package me.capit.city16.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.city16.player.CityPlayer;

public class Group implements Serializable {
	private static final long serialVersionUID = 1729482110019256483L;
	public final UUID ID;
	public final City city;
	public final List<CityPlayer> players;
	public String name;
	
	public Group(City city, String name){
		ID = UUID.randomUUID();
		players = new ArrayList<CityPlayer>();
		this.city = city;
		this.name = name;
	}
}
