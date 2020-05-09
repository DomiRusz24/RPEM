package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.elemental.listeners.ElementalListener;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.Element;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.ParticleRay;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneSymbol;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneTable;
import pl.alvion.rpem.rpessentials.magic.utils.RayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class LightningBolt extends RuneSymbol {


    @Override
    public void activate(Player player, Location middle) {
        ArrayList<ParticleRay> particleRays = RuneTable.getPlayerTable(player).getRays();
        for (ParticleRay particleRay : particleRays) {
            particleRay.changeColor(Color.AQUA);
            particleRay.createRay(5, 5);
        }

        ElementalListener.setNextInteractEvent(player, () -> {nextActivate(player);});


    }

    private void nextActivate(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                RuneTable runeTable = new RuneTable(player, moves(), 1.7);
                ArrayList<ParticleRay> particleRays = runeTable.getRays();
                for (ParticleRay particleRay : particleRays) {
                    particleRay.makeSmaller(runeTable.getMiddle());
                    particleRay.changeColor(Color.AQUA);
                    particleRay.createRay(3, 10);
                }
                player.getWorld().strikeLightning(RayUtils.getTargetedLocationOrEntity(player, 100, 1, RayUtils.transparentMaterials, 1));
            }
        }.runTaskLater(RPEssentials.plugin, 20);

    }


    @Override
    public ArrayList<Integer> moves() {
        return new ArrayList<>(Arrays.asList(4,16,16,25,25,37));
    }

    @Override
    public boolean canDraw(Player player) {
        return Element.getSelectedElement(player).equals(Element.FIRE);
    }
}
