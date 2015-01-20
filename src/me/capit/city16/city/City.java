package me.capit.city16.city;

import org.bukkit.ChatColor;

import me.capit.city16.player.CityPlayer;
import me.capit.eapi.data.DataModel;
import me.capit.eapi.data.value.StringValue;

public class City extends DataModel {
	private static final long serialVersionUID = -4636309141335506889L;
	
	public static final String defaultDesc = ChatColor.ITALIC+"No description set.";
	
	private GroupsModel groups;
	
	public City(String name, CityPlayer owner){
		super(name);
		
		addAttribute(new StringValue("desc", defaultDesc));
		
		groups = new GroupsModel();
		groups.addChild(new Group("admin", owner));
		groups.addChild(new Group("default"));
		groups.setDefaultChildID(groups.findFirstChild("default").getUniqueID());
		this.addChild(groups);
		
	}
	
	public DistrictsModel getDistrictsModel(){
		return districts;
	}
	
	public GroupsModel getGroupsModel(){
		return groups;
	}
}
