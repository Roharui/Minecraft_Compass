package main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CompassController extends Thread{

	@Override
	public void run() {
		while(true)
		{
			for(Player item : Bukkit.getOnlinePlayers())
			{
				String target = Event.pMap.get(item.getDisplayName());
				if(target == null) return;
				
				item.setCompassTarget(Bukkit.getPlayer(target).getLocation());
			}
		}
		
	}

}
