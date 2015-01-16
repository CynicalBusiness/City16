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
