package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum HealingStages {
    Start("Regeneracja"),
    Healed("Prawie wyleczone");

    private String polskiID;

    HealingStages(String PolskiID) {
        this.polskiID = PolskiID;
    }

    public String getPolskiID() {
        return polskiID;
    };
}
