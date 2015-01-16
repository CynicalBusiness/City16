package me.capit.city16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.city16.city.City;
import me.capit.city16.player.CityPlayer;
import me.capit.eapi.DataHandler;
import me.capit.eapi.data.Child;
import me.capit.eapi.data.DataFile;
import me.capit.eapi.data.value.ObjectValue;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CityPlugin extends JavaPlugin {
	public static final String citiesFile = "cities";
	public static final String playersFile = "players";
	
	private ConfigurationSection defaults;
	private static DataFile file;
	private static DataFile players;
	
	
	@Override
	public void onEnable(){
		load();
	}
	
	@Override
	public void onDisable(){
		save();
	}
	
	public void load(){
		try {
			file = DataHandler.loadFile(this, citiesFile);
			players = DataHandler.loadFile(this, playersFile);
		} catch (ClassNotFoundException | ClassCastException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(){
		try {
			file.save(this);
			players.save(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static CityPlayer getPlayer(UUID id){
		for (Child child : players.getChildren()){
			@SuppressWarnings("unchecked")
			ObjectValue<CityPlayer> pval = (ObjectValue<CityPlayer>) child;
			if (pval.getValue().playerID.equals(id)) return pval.getValue();
		}
		return null;
	}
	
	public static void addPlayer(Player player){
		players.addChild(new ObjectValue<CityPlayer>("player", new CityPlayer(player)));
	}
	
	public static List<City> getCities(){
		List<City> cities = new ArrayList<City>();
		for (Child child : file.getChildren()) if (child instanceof City) cities.add((City) child);
		return cities;
	}
	
	public static City getCity(UUID id){
		for (City city : getCities()) if (city.getUniqueID().equals(id)) return city;
		return null;
	}
}
