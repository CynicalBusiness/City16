package me.capit.city16.city;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class District implements Serializable {
	private static final long serialVersionUID = -4858279646085128726L;
	
	public final UUID ID;
	public final City city;
	public final List<Territory> territory;
	public String name;
	
	public District(City city, String name){
		ID = UUID.randomUUID();
		this.city = city;
		this.name = name;
		territory = new ArrayList<Territory>();
	}
}
