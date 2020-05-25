package pl.alvion.rpem.rpessentials.magic.elemental.symbols;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.Element;
import pl.alvion.rpem.rpessentials.magic.elemental.runedraw.RuneSymbol;

import java.util.ArrayList;
import java.util.Arrays;

public class UniversalSelect extends RuneSymbol {
    @Override
    public void activate(Player player, Location middle) {
        Element.selectElement(player, Element.UNIVERSAL);
    }

    @Override
    public ArrayList<Integer> moves() {
        return new ArrayList<>(Arrays.asList(6, 42));
    }
}
