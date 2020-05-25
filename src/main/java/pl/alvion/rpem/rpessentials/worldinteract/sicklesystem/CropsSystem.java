package pl.alvion.rpem.rpessentials.worldinteract.sicklesystem;

import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Crops;

import java.util.ArrayList;
import java.util.Arrays;

public class CropsSystem implements Listener {


    ArrayList<Material> applicableMaterials = new ArrayList<>(Arrays.asList(Material.WHEAT, Material.CARROTS, Material.POTATOES, Material.BEETROOTS));
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (!applicableMaterials.contains(block.getType())) return;
        Crops crops = (Crops) block.getState();
        CropState cropState = crops.getState();
        Material material = block.getType();

        if (material.equals(Material.WHEAT)) {
            if (!cropState.equals(CropState.RIPE)) {

            }
        }

    }


}
