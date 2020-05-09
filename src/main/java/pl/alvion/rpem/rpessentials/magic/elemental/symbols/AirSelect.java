package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AirSelect extends RuneSymbol {
    @Override
    public void activate(Player player, Location middle) {
        Element.selectElement(player, Element.AIR);
        RuneTable runeTable = RuneTable.getPlayerTable(player);
        ArrayList<ParticleRay> particleRays = runeTable.getRays();
        for (ParticleRay particleRay : particleRays) {
            particleRay.changeColor(Color.WHITE);
            Element.playElementSound(player, Element.AIR,  5, 5);
            particleRay.createRay(1, 20, 0.01);
        }
        for (RunePoint runePoint : runeTable.runePoints) {
            player.spawnParticle(Particle.REDSTONE, runePoint.location, 0, 0.0001, 1, 1, 1, new Particle.DustOptions(Color.WHITE, 0.5f));
        }


    }

    @Override
    public ArrayList<Integer> moves() {
        return new ArrayList<>(Arrays.asList(39,37,37,29,29,15,15,9,9,11,11,19,19,26,26,32,32,31,31,23,23,17,17,25,25,24));
    }
}
