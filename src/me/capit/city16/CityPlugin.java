package me.capit.city16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.city16.city.City;
import me.capit.eapi.serialization.ObjectHandler;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public class CityPlugin extends JavaPlugin {
	public static final String citiesFile = "cities";
	
	private ConfigurationSection defaults;
	private List<City> cities;
	
	
	@Override
	public void onEnable(){
		load();
	}
	
	@Override
	public void onDisable(){
		save();
	}
	
	@SuppressWarnings("unchecked")
	public void load(){
		try {
			Object citiesObject = ObjectHandler.deserializeFromPlugin(this, citiesFile);
			ArrayList<?> list = (ArrayList<?>) citiesObject;
			cities = (ArrayList<City>) list;
		} catch (FileNotFoundException e){
			new File(getDataFolder(), citiesFile+"."+ObjectHandler.extension);
			cities = new ArrayList<City>();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			this.setEnabled(false);
		}
	}
	
	public void save(){
		try {
			ObjectHandler.serializeToPlugin(this, citiesFile, cities);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public City getCity(UUID id){
		for (City city : cities) if (city.ID.equals(id)) return city;
		return null;
	}
}
