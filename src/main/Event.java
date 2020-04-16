package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;

public class Event implements Listener{
	
	public static Map<String, String> pMap = new HashMap<String, String>();
	
	private InventoryGui gui = new InventoryGui();
	
	@EventHandler
	public void CompassEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(!(e.getAction() == Action.RIGHT_CLICK_AIR || 
				e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		
		if(p.getEquipment().getItemInMainHand().getType().equals(Material.COMPASS))
		{
			gui.showGui(p);
		}
	}
	
	@EventHandler
	public void InventoryEvent(InventoryClickEvent e)
	{
		InventoryView inv = e.getView();
		if(inv.getTitle() != "Compass GUI") return;
		
		ItemStack item = e.getCurrentItem();
		if(item.getType() != Material.PLAYER_HEAD) return;
		
		String name = item.getItemMeta().getDisplayName();
		
		putOrReviseMap(((Player)e.getWhoClicked()).getDisplayName(), name);
		
		e.setCancelled(true);
	}
	
	private void putOrReviseMap(String p, String t)
	{
		String a = pMap.get(p);
		if(a == null) {
			pMap.put(p, t);
		}else
		{
			pMap.replace(p, t);
		}
	}
}
