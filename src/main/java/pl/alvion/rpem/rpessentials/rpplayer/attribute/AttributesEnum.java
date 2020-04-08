package pl.alvion.rpem.rpessentials.rpplayer.attribute;


public enum AttributesEnum {
    Melee(AttributeTypes.Offence),
    AxeHandling(AttributeTypes.Offence),
    SwordHandling(AttributeTypes.Offence),
    ShieldHandling(AttributeTypes.Offence),
    BowShooting(AttributeTypes.Offence),
    Throwing(AttributeTypes.Offence),
    MagicOne(AttributeTypes.Offence),
    MagicTwo(AttributeTypes.Offence),
    MagicThree(AttributeTypes.Offence),
    Crafting(AttributeTypes.Crafts),
    Alchemy(AttributeTypes.Crafts),
    Smiting(AttributeTypes.Crafts),
    Enchanting(AttributeTypes.Crafts),
    Mining(AttributeTypes.Crafts),
    WoodChopping(AttributeTypes.Crafts),
    Farming(AttributeTypes.Crafts),
    Breeding(AttributeTypes.Crafts),
    Stealing(AttributeTypes.Crafts),
    Healing(AttributeTypes.Crafts),
    Stamina(AttributeTypes.Body),
    Resistance(AttributeTypes.Body),
    Sneaking(AttributeTypes.Body);

    private AttributeTypes type;
    private Attribute attributetype;

    AttributesEnum(AttributeTypes type) {
        this.type = type;
        this.attributetype = attributetype;
    }

    public AttributeTypes getType() {
        return type;
    }

    public Attribute getAttribute() {
        return attributetype;
    }
}
