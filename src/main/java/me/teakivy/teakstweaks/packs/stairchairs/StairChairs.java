package me.teakivy.teakstweaks.packs.stairchairs;

import me.teakivy.teakstweaks.packs.BasePack;
import me.teakivy.teakstweaks.packs.PackType;
import me.teakivy.teakstweaks.utils.MM;
import me.teakivy.teakstweaks.utils.permission.Permission;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Marker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class StairChairs extends BasePack {

    public StairChairs() {
        super("stair-chairs", PackType.TEAKSTWEAKS, Material.SMOOTH_QUARTZ_STAIRS);
    }


    @EventHandler
    public void onChairMaker(PlayerInteractEvent event) {
        if (!Permission.STAIR_CHAIRS_CREATE.check(event.getPlayer())) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.SADDLE) return;
        if (event.getClickedBlock() == null) return;
        if (!event.getClickedBlock().getType().toString().contains("STAIRS")) return;
        if (isChair(event.getClickedBlock().getLocation())) return;

        if (((Stairs) event.getClickedBlock().getBlockData()).getHalf() != Stairs.Half.BOTTOM) return;

        Location loc = event.getClickedBlock().getLocation();
        if (event.getPlayer().getGameMode() != org.bukkit.GameMode.CREATIVE) {
            event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
        }


        Marker marker = (Marker) Objects.requireNonNull(loc.getWorld()).spawnEntity(loc, EntityType.MARKER);
        marker.addScoreboardTag("chair");

        MM.player(event.getPlayer()).sendMessage(getText("chair_created"));
    }

    public boolean isChair(Location loc) {
        for (Object o : loc.getBlock().getWorld().getNearbyEntities(loc, 1, 1, 1).stream().toArray()) {
            if (o instanceof Marker) {
                return ((Marker) o).getScoreboardTags().contains("chair");
            }
        }
        return false;
    }

    @EventHandler
    public void onChairDestroy(BlockBreakEvent event) {
        if (!isChair(event.getBlock().getLocation())) return;
        Location loc = event.getBlock().getLocation();
        for (Object o : loc.getBlock().getWorld().getNearbyEntities(loc, 1, 1, 1).stream().toArray()) {
            if (o instanceof Marker) {
                ((Marker) o).remove();
            }
        }
        event.getBlock().getWorld().dropItem(loc.add(.5, .5, .5), new ItemStack(Material.SADDLE));
        MM.player(event.getPlayer()).sendMessage(getText("chair_destroyed"));
    }

    @EventHandler
    public void onSit(PlayerInteractEvent event) {
        if (!Permission.STAIR_CHAIRS_SIT.check(event.getPlayer())) return;
        if (event.getPlayer().isSneaking()) return;
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR) return;
        if (!isChair(block.getLocation())) return;
        if (!block.getType().name().toLowerCase().contains("stairs")) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (block.getLocation().add(0, 1, 0).getBlock().getType() != Material.AIR) return;
        AreaEffectCloud seat = (AreaEffectCloud) block.getWorld().spawnEntity(block.getLocation().add(.5, 0, .5), EntityType.AREA_EFFECT_CLOUD);
        seat.setRotation(0, 90);
        seat.addScoreboardTag("chair-rider");
        seat.setInvulnerable(true);
        seat.setDuration(Integer.MAX_VALUE);
        seat.setParticle(Particle.FLAME);
        seat.setWaitTime(0);
        seat.setColor(Color.WHITE);
        seat.setRadius(.001F);
        seat.addPassenger(event.getPlayer());
    }

    @EventHandler
    public void onDismount(EntityDismountEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getDismounted().getScoreboardTags().contains("chair-rider")) event.getDismounted().remove();
        event.getEntity().teleport(event.getEntity().getLocation().add(0, 1, 0));
    }
}
