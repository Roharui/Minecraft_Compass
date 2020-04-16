package main;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class InventoryGui {
	
	public void showGui(Player p)
	{
		List<Player> pLst = (List<Player>) Bukkit.getOnlinePlayers();
		
		if(pLst.size() == 1) {
			p.sendMessage("There is no one toTarget");
			return;
		}
		
		int invSize = (int)pLst.size()/9;
		invSize += (pLst.size()%9 == 0) ? 0 : 1;
		
		Inventory inv = Bukkit.createInventory(null, invSize * 9, "Compass GUI");
		
		for(Player item : pLst)
		{
			if(item.getDisplayName() == p.getDisplayName()) continue;
			inv.addItem(getPlayerHead(item));
		}
		
		p.openInventory(inv);
	}
	
	private ItemStack getPlayerHead(Player p)
	{
		ItemStack result = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta meta = result.getItemMeta();
		
		result.setAmount(1);
		
		meta.setDisplayName(p.getDisplayName());
		
		result.setItemMeta(meta);
		
		return result;
	}
}
