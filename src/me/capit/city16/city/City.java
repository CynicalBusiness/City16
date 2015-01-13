package me.capit.city16.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

import me.capit.city16.CityPlugin;
import me.capit.city16.player.CityPlayer;

public class City implements Serializable {
	private static final long serialVersionUID = -4636309141335506889L;

	public static transient final long debugID = System.currentTimeMillis();
	
	public final UUID ID;
	public final List<District> districts;
	public final List<Group> groups;
	public UUID defaultDistrict, defaultGroup;
	public String name,desc;
	
	public City(CityPlugin plugin, String name, CityPlayer owner, UUID world){
		ID = UUID.randomUUID();
		this.name = name;
		
		districts = new ArrayList<District>();
		District def = new District(this, "Default", world);
		defaultDistrict = def.ID;
		districts.add(def);
		
		groups = new ArrayList<Group>();
		Group ag = new Group(this, "Admin");
		ag.players.add(owner);
		groups.add(ag);
		Group dg = new Group(this, "Default");
		defaultGroup = dg.ID;
		groups.add(dg);
	}
	
	// DISTRICTS -----------------------------------------------------
	public District getDistrict(UUID id){
		for (District d : districts) if (d.ID.equals(id)) return d;
		return null;
	}
	public District getDistrict(Location loc){
		for (District dist : districts) if (dist.hasTerritory(loc)) return dist;
		return null;
	}
	
	public boolean hasDistrict(UUID id){
		return getDistrict(id)!=null;
	}
	public boolean hasDistrict(Location loc){
		return getDistrict(loc)!=null;
	}
	
	public District getDefaultDistrict(){
		return getDistrict(defaultDistrict);
	}
	public List<District> getDistrictsInWorld(UUID wid){
		List<District> dists = new ArrayList<District>();
		for (District d : districts) if (d.world.equals(wid)) dists.add(d);
		return dists;
	}
	
	// GROUPS --------------------------------------------------------
	public Group getGroup(UUID id){
		for (Group g : groups) if (g.ID.equals(id)) return g;
		return null;
	}
	public Group getDefaultGroup(){
		return getGroup(defaultGroup);
	}
	
	// PLAYERS -------------------------------------------------------
	public List<CityPlayer> getPlayers(){
		List<CityPlayer> players = new ArrayList<CityPlayer>();
		for (Group group : groups) for (CityPlayer player : group.players) players.add(player);
		return players;
	}
	public void addPlayer(CityPlayer player){
		getDefaultGroup().players.add(player);
	}
	
	// TERRITORY ----------------------------------------------------
	public List<Territory> getTerritory(){
		List<Territory> claims = new ArrayList<Territory>();
		for (District district : districts) for (Territory territory : district.territory) claims.add(territory);
		return claims;
	}
	public void claim(Territory territory) throws CityException{
		getDefaultDistrict().territory.add(territory);
	}
}
