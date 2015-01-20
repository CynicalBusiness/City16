package me.capit.city16.city.fortification;

import java.util.UUID;

import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.Parent;
import me.capit.eapi.item.MaterialParser;
import me.capit.eapi.math.Vector3;
public class Fortification implements Child {
	private static final long serialVersionUID = -8080790824117580791L;

	private final UUID world;
	private Vector3 location;
	private FortificationParser fort;
	
	public Fortification(FortificationParser data){
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUniqueID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parent getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(Parent arg0) {
		// TODO Auto-generated method stub
		
	}
}
