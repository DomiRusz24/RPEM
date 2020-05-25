package pl.alvion.rpem.rpessentials.worldinteract.sicklesystem;

import org.bukkit.Material;

public enum Sickles {

    IRON_SICKLE(Material.IRON_HOE, 0);

    Material material;
    int customModelData;

    Sickles(Material material, int customModelData) {
        this.material = material;
        this.customModelData = customModelData;
    }


}
