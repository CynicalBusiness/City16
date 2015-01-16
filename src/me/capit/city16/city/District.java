<<<<<<< HEAD
package me.capit.city16.city;

import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.value.StringValue;

public class District extends DataModel {
	private static final long serialVersionUID = -4858279646085128726L;
	
	public District(String name, String world){
		super(name);
		addAttribute(new StringValue("world", world));
	}
	
	@Override
	public void addChild(Child child){
		if (child instanceof Territory) super.addChild(child);
	}
	
	public String getWorld(){
		return getAttribute("world").getValueString();
	}
	
	public boolean hasX(int x){
		for (Child c : getChildren()){
			Territory t = (Territory) c;
			if (t.getX()==x) return true;
		}
		return false;
	}
	
	public boolean hasZ(int z){
		for (Child c : getChildren()){
			Territory t = (Territory) c;
			if (t.getZ()==z) return true;
		}
		return false;
	}
	
	public Territory getTerritory(int x, int z){
		for (Child c : getChildren()){
			Territory t = (Territory) c;
			if (t.getZ()==z && t.getX()==x) return t;
		}
		return null;
	}
	
	public boolean hasTerritory(int x, int z){
		return getTerritory(x,z)!=null;
	}
}
=======
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
>>>>>>> branch 'master' of https://github.com/Wehttam664/City16
