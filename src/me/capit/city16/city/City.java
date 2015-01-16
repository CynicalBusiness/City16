package me.capit.city16.city;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.capit.city16.CityPlugin;
import me.capit.city16.player.CityPlayer;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.Model;
import me.capit.eapi.data.value.ObjectValue;
import me.capit.eapi.data.value.StringValue;

public class City extends DataModel {
	private static final long serialVersionUID = -4636309141335506889L;
	
	public static final String defaultDesc = ChatColor.ITALIC+"No description set.";
	
	private DataModel districts, groups;
	
	public City(String name, UUID owner){
		super(name);
		
		addAttribute(new StringValue("desc", defaultDesc));
		
		districts = new DataModel("districts");
		districts.addAttribute(new ObjectValue<UUID>("default", null));
		addChild(districts);
		
		groups = new DataModel("groups");
		Group ag = new Group("admin");
		ag.addChild(new ObjectValue<UUID>("player", owner));
		groups.addChild(ag);
		Group dg = new Group("default");
		groups.addAttribute(new ObjectValue<UUID>("default", dg.getUniqueID()));
		groups.addChild(dg);
		addChild(groups);
	}
	
	// DISTRICTS -----------------------------------------------------
	public List<District> getDistricts(){
		List<District> districts = new ArrayList<District>();
		for (Child child : this.districts.getChildren()) if (child instanceof District) districts.add((District) child);
		return districts;
	}
	public District getDistrict(UUID id){
		for (District d : getDistricts()) if (d.getUniqueID().equals(id)) return d;
		return null;
	}
	public District getDistrict(Territory territory){
		return getDistrict(territory.getWorld(), territory.getX(), territory.getZ());
	}
	public District getDistrict(String world, int x, int z){
		for (District d : getDistricts()) if (d.getWorld().equals(world) && d.hasTerritory(x, z)) return d;
		return null;
	}
	@SuppressWarnings("unchecked")
	public District getDefaultDistrict(){
		return getDistrict(((ObjectValue<UUID>) districts.getAttribute("default")).getValue());
	}
	
	// GROUPS --------------------------------------------------------
	public List<Group> getGroups(){
		List<Group> groups = new ArrayList<Group>();
		for (Child child : this.groups.getChildren()) if (child instanceof Group) groups.add((Group) child);
		return groups;
	}
	public Group getGroup(UUID id){
		for (Group g : getGroups()) if (g.getUniqueID().equals(id)) return g;
		return null;
	}
	@SuppressWarnings("unchecked")
	public Group getDefaultGroup(){
		return getGroup(((ObjectValue<UUID>) groups.getAttribute("default")).getValue());
	}
	
	// PLAYERS -------------------------------------------------------
	public List<CityPlayer> getPlayers(){
		List<CityPlayer> players = new ArrayList<CityPlayer>();
		for (Group group : getGroups()) for (Child ) players.add(player);
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
