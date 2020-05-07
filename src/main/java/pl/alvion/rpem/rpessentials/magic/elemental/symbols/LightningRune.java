package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.Element;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.ParticleRay;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneSymbol;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneTable;
import pl.alvion.rpem.rpessentials.magic.utils.RayUtils;

import java.util.ArrayList;

public class LightningRune extends RuneSymbol {


    @Override
    public void activate(Player player, Location middle) {
        ArrayList<ParticleRay> particleRays = RuneTable.getPlayerTable(player).getRays();
        for (ParticleRay particleRay : particleRays) {
            particleRay.toPlayer(player, middle);
            particleRay.makeSmaller(middle);
        }
        new BukkitRunnable() {
            @Override
            public void run() {

                for (ParticleRay particleRay : particleRays) {
                    particleRay.changeColor(Color.AQUA);
                    particleRay.createRay(3, 10);
                }
                player.getWorld().strikeLightning(RayUtils.getTargetedLocationOrEntity(player, 100, 1, RayUtils.transparentMaterials, 1));
            }
        }.runTaskLater(RPEssentials.plugin, 20);


    }


    @Override
    public ArrayList<Integer> moves() {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(4);
        moves.add(16);
        moves.add(16);
        moves.add(25);
        moves.add(25);
        moves.add(37);
        return moves;
    }

    @Override
    public boolean canDraw(Player player) {
        return Element.getSelectedElement(player).equals(Element.FIRE);
    }
}
