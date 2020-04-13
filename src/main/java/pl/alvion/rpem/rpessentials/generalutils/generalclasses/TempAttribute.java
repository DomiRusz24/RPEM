package pl.alvion.rpem.rpessentials.generalutils.generalclasses;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class TempAttribute {
    public static void addToPlayerAttribute(Player player, Attribute attribute, double value) {
        player.getAttribute(attribute).setBaseValue(player.getAttribute(attribute).getDefaultValue());
    }

    private Attribute attribute;
    private double value;
    private Player player;

    public TempAttribute(Player player, Attribute attribute) {
        this.attribute = attribute;
        this.player = player;
        value = 0;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public double getValue() {
        return value;
    }

    public void attributeAdd(double value) {
        this.value = value + this.value;
        addToPlayerAttribute(player, attribute, value);

    }

    public void attributeMultiply(double value) {
        this.value = this.value +  (player.getAttribute(attribute).getDefaultValue() - (player.getAttribute(attribute).getDefaultValue() * value));
        addToPlayerAttribute(player, attribute, player.getAttribute(attribute).getDefaultValue() * value);
    }

    public void restore() {
        addToPlayerAttribute(player, attribute, this.value*-1);
        this.value = 0;
    }
}
