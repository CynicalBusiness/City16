package me.capit.city16.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

public class Territory implements Serializable {
	private static final long serialVersionUID = -6306417376625096692L;
	
	public final District district;
	public final City city;
	public final UUID ID;
	public final String world;
	public final int x,z;
	public final List<Fortification> fortifications;
	
	public Territory(District district, String world, int x, int z){
		ID = UUID.randomUUID();
		this.district = district;
		this.city = district.city;
		this.world = world;
		this.x = x; this.z = z;
		fortifications = new ArrayList<Fortification>();
	}
	
	public Fortification getFortification(Location loc){
		for (Fortification fort : fortifications) 
			if (fort.x==loc.getBlockX() && fort.y==loc.getBlockY() && fort.z==loc.getBlockZ()) return fort;
		return null;
	}
}
