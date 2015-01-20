package me.capit.city16.city;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.city16.player.CityPlayer;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.value.ObjectValue;

public class GroupsModel extends DataModel {
	private static final long serialVersionUID = -98003566800687616L;

	public GroupsModel(){
		super("groups");
		addAttribute(new ObjectValue<UUID>("default", null));
	}
	
	public GroupsModel(Group... districts) {
		this();
		for (Group d : districts) addChild(d);
	}
	
	@Override
	public void addChild(Child child){
		if (child instanceof Group) super.addChild(child);
	}
	
	@Override
	public Group findFirstChild(String name){
		return super.findFirstChild(name)!=null ? (Group) super.findFirstChild(name) : null;
	}
	
	@Override
	public Group getChild(UUID id){
		return super.getChild(id) != null ? (Group) (super.getChild(id)) : null;
	}
	
	public List<Group> getGroups(){
		List<Group> groups = new ArrayList<Group>();
		for (Child child : super.getChildren()) if (child instanceof Group) groups.add((Group) child);
		return groups;
	}
	
	@SuppressWarnings("unchecked")
	private ObjectValue<UUID> getIDValue(){
		return (ObjectValue<UUID>) getAttribute("default");
	}
	
	public void setDefaultChildID(UUID id){
		getIDValue().setValue(id);
	}
	
	public UUID getDefaultChildID(){
		return getIDValue().getValue();
	}
	
	public Group getDefaultChild(){
		return getChild(getDefaultChildID());
	}
	
	public List<CityPlayer> getPlayers(){
		List<CityPlayer> players = new ArrayList<CityPlayer>();
		for (Group group : getGroups()) for (CityPlayer player : group.getPlayers()) players.add(player);
		return players;
	}
}
