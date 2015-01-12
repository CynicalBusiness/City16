package me.capit.city16.city;

import java.io.Serializable;

public class Fortification implements Serializable {
	private static final long serialVersionUID = -8080790824117580791L;
	
	public final City city;
	public final District district;
	public final Territory territory;
	public final String world;
	public final int x,y,z;
	
	public Fortification(Territory territory, String world, int x, int y, int z){
		this.territory = territory;
		this.district = territory.district;
		this.city = territory.city;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
