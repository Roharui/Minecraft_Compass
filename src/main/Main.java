package main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	
	private static Thread cpsCtr = new CompassController();
	
	@Override
	public void onEnable()
	{
		cpsCtr.start();
		loadEvent();
		getLogger().info("Hello World");
	}
	
	private void loadEvent()
	{
		getServer().getPluginManager().registerEvents(new Event(), this);
	}
	
}
