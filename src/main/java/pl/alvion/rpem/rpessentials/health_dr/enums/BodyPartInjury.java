package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum BodyPartInjury {
    Scratch("Podrapanie", 0),
    Scar("Blizna", 1),
    Bruise("Siniak", 2),
    Bleed("Krwawienie", 3),
    Infection("Infekcja", 4),
    Broken("Zlamanie", 5),
    Amputation("Amputacja", 6),
    Wound("Rana", 7),
    Burn("Poparzenie", 8),
    Inefficient("NieSprawny", 9);

    protected String PolishIdentification;
    protected int id;

    BodyPartInjury(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkBodyPartInjuryFromID(int id) {
        for (BodyPartInjury bodyPartInjury : BodyPartInjury.values()) {
            if (bodyPartInjury.id == id) {
                return true;
            }
        }
        return false;
    }

    public static BodyPartInjury getBodyPartInjuryFromID(int id) {
        for (BodyPartInjury bodyPartInjury : BodyPartInjury.values()) {
            if (bodyPartInjury.id == id) {
                return bodyPartInjury;
            }
        }
        System.out.println("ERROR: Przy metodzie getBodyPartInjuryFromID sprawdz czy takie ID istnieje! (checkBodyPartInjuryFromID)");
        return null;
    }

    public static Boolean checkBodyPartInjuryFromPolish(String polishIdentification) {
        for (BodyPartInjury bodyPartInjury : BodyPartInjury.values()) {
            if (bodyPartInjury.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static BodyPartInjury getBodyPartInjuryFromPolish(String polishIdentification) {
        for (BodyPartInjury bodyPartInjury : BodyPartInjury.values()) {
            if (bodyPartInjury.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return bodyPartInjury;
            }
        }
        System.out.println("ERROR: Przy metodzie getBodyPartInjuryFromPolish sprawdz czy taka nazwa istnieje! (checkBodyPartInjuryFromPolish)");
        return null;
    }
}
