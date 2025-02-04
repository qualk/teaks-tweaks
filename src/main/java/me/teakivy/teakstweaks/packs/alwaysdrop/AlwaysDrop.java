package me.teakivy.teakstweaks.packs.alwaysdrop;

import me.teakivy.teakstweaks.packs.BasePack;
import me.teakivy.teakstweaks.packs.PackType;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class AlwaysDrop extends BasePack {

    public AlwaysDrop() {
        super("always-drop", PackType.SURVIVAL, Material.ENDER_CHEST);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        List<String> blockList = getConfig().getStringList("blocks");
        for (String block : blockList) {
            if (event.getBlock().getType().toString().equalsIgnoreCase(block)) {
                event.setDropItems(false);
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(event.getBlock().getType()));
            }
        }
    }
}
