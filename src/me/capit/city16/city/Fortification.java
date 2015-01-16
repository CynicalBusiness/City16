package me.capit.city16.city;

import java.io.Serializable;

import org.bukkit.Material;

public class Fortification implements Serializable {
	private static final long serialVersionUID = -8080790824117580791L;
	
	public static final int getHealthFrom(Material type){
		switch (type){
		case STONE: return 16;
		case LEATHER: case OBSIDIAN: return 32;
		case GOLD_INGOT: return 64;
		case IRON_INGOT: return 128;
		case DIAMOND: return 256;
		case EMERALD: return 512;
		default: return 0;
		}
	}
	
	public final City city;
	public final District district;
	public final Territory territory;
	public final String world;
	public final int x,y,z;
	private int health;
	
	public Fortification(Territory territory, String world, int x, int y, int z,
			Material type) throws IllegalArgumentException {
		this.territory = territory;
		this.district = territory.district;
		this.city = territory.city;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.health = getHealthFrom(type);
	}
	
	public int getHealth(){
		return health;
	}
	
	public void damage(){
		health--;
	}
}
