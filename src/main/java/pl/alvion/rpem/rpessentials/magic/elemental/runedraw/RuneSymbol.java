package pl.alvion.rpem.rpessentials.magic.elemental.runedraw;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.magic.elemental.symbols.*;

import java.util.ArrayList;

public abstract class RuneSymbol {


    public static void onEnable() {
        runeSymbols.add(new UniversalSelect());
        runeSymbols.add(new LightningBolt());
        runeSymbols.add(new FireSelect());
        runeSymbols.add(new FlameThrower());
        runeSymbols.add(new AirSelect());
    }

    public abstract void activate(Player player, Location middle);
    static ArrayList<RuneSymbol> runeSymbols = new ArrayList<>();

    public abstract ArrayList<Integer> moves();
    public boolean canDraw(Player player) {
        return true;
    }


    public boolean compareWithTable(RuneTable runeTable) {
        if (moves().size() < runeTable.moves.size()) return false;
        try {
            for (int i = 0; i < moves().size(); i++) {
                ArrayList<Integer> moves = moves();
                if (!moves.get(i).equals(runeTable.moves.get(i))) {
                    return false;
                }
            }
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }




}
