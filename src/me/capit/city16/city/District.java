package me.capit.city16.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

public class District implements Serializable {
	private static final long serialVersionUID = -4858279646085128726L;
	
	public final UUID ID, world;
	public final City city;
	public final List<Territory> territory;
	public String name;
	
	public District(City city, String name, UUID world){
		ID = UUID.randomUUID();
		this.world = world;
		this.city = city;
		this.name = name;
		territory = new ArrayList<Territory>();
	}
	
	public Territory getTerritory(Location loc){
		if (!loc.getWorld().getUID().equals(world)) return null;
		for (Territory t : territory) 
			if (t.x==loc.getChunk().getX() && t.z==loc.getChunk().getZ()) return t;
		return null;
	}
	public Territory getTerritory(UUID id){
		for (Territory t : territory) if (t.ID.equals(id)) return t;
		return null;
	}
	
	public boolean hasTerritory(Location loc){
		return getTerritory(loc)!=null;
	}
	public boolean hasTerritory(UUID id){
		return getTerritory(id)!=null;
	}
}
