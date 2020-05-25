package pl.alvion.rpem.rpessentials.magic.elemental.runedraw;

import org.bukkit.Color;
import org.bukkit.Location;

public class RunePoint {
    public Location location;
    Color color;
    RunePointState runePointState = RunePointState.INACTIVE;

    public RunePoint(Location location, Color color) {
        this.location = location;
        this.color = color;
    }

}
