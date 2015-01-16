package me.capit.city16.city;

import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.value.IntValue;
import me.capit.eapi.data.value.StringValue;

public class Territory extends DataModel {
	private static final long serialVersionUID = -6306417376625096692L;
	
	public Territory(String world, int x, int z){
		super("territory");
		addAttribute(new StringValue("world", world));
		addAttribute(new IntValue("x", x));
		addAttribute(new IntValue("z", z));
	}
	
	public String getWorld(){
		return getAttribute("world").getValueString();
	}
	
	public int getX(){
		return (int) ((IntValue) getAttribute("x")).getPrimitiveValue();
	}
	
	public int getZ(){
		return (int) ((IntValue) getAttribute("z")).getPrimitiveValue();
	}
}
