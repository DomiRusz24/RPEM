package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum Organ {
    Brain("Mozg", 0),
    Heart("Serce", 1),
    Lungs("Pluca", 2),
    Stomach("Zoladek", 3);

    protected String PolishIdentification;
    protected int id;

    Organ(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkOrganFromID(int id) {
        for (Organ organ : Organ.values()) {
            if (organ.id == id) {
                return true;
            }
        }
        return false;
    }

    public static Organ getOrganFromID(int id) {
        for (Organ organ : Organ.values()) {
            if (organ.id == id) {
                return organ;
            }
        }
        System.out.println("ERROR: Przy metodzie getOrganFromID sprawdz czy takie ID istnieje! (checkOrganFromID)");
        return null;
    }

    public static Boolean checkOrganFromPolish(String polishIdentification) {
        for (Organ organ : Organ.values()) {
            if (organ.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static Organ getOrganFromPolish(String polishIdentification) {
        for (Organ organ : Organ.values()) {
            if (organ.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return organ;
            }
        }
        System.out.println("ERROR: Przy metodzie getOrganFromPolish sprawdz czy taka nazwa istnieje! (checkOrganFromPolish)");
        return null;
    }
}
