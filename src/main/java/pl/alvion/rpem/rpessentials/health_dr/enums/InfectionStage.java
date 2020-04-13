package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum InfectionStage {
    Low("Poczatek", 1),
    Medium("Wstepne objawy", 2),
    High("Wszystkie objawy", 3),
    Highest("Smiertelne", 4);


    private String PolishId;
    private int id;

    InfectionStage(String PolishID, int id) {
        this.id = id;
        this.PolishId = PolishID;
    }

    public int getId() {
        return id;
    }

    public String getPolishId() {
        return PolishId;
    }
}
