package me.capit.city16.city.fortification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;

import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.math.Vector3;

public class FortificationModel extends DataModel {
	private static final long serialVersionUID = -1736049955730344573L;
	
	public FortificationModel(){
		super("fortifications");
	}
	
	public FortificationModel(Fortification forts){
		super("fortifications", forts);
	}
	
	@Override
	public void addChild(Child child){
		if (child instanceof Fortification) super.addChild(child);
	}
	
	public Fortification findFirstChild(Location loc){
		return findFirstChild(loc.getWorld().getUID(), new Vector3(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
	}
	
	public Fortification findFirstChild(UUID world, Vector3 loc){
		for (Fortification fort : getFortifications())
	}
	
	public List<Fortification> getFortifications(){
		List<Fortification> forts = new ArrayList<Fortification>();
		for (Child child : getChildren()) if (child instanceof Fortification) forts.add((Fortification) child);
		return forts;
	}
}
