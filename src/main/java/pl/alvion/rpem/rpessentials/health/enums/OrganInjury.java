package pl.alvion.rpem.rpessentials.health.enums;

public enum OrganInjury {
    TotalFailure("CalkowitaAwaria", 0),
    InternalBleed("Krwawienie", 1),
    RippedOut("Wyrwane", 2),
    Inefficient("NieSprawny", 3);




    protected String PolishIdentification;
    protected int id;

    OrganInjury(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public static Boolean checkOrganInjuryFromID(int id) {
        for (OrganInjury organInjury : OrganInjury.values()) {
            if (organInjury.id == id) {
                return true;
            }
        }
        return false;
    }

    public static OrganInjury getOrganInjuryFromID(int id) {
        for (OrganInjury organInjury : OrganInjury.values()) {
            if (organInjury.id == id) {
                return organInjury;
            }
        }
        System.out.println("ERROR: Przy metodzie getOrganInjuryFromID sprawdz czy takie ID istnieje! (checkOrganInjuryFromID)");
        return null;
    }

    public static Boolean checkOrganInjuryFromPolish(String polishIdentification) {
        for (OrganInjury organInjury : OrganInjury.values()) {
            if (organInjury.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static OrganInjury getOrganInjuryFromPolish(String polishIdentification) {
        for (OrganInjury organInjury : OrganInjury.values()) {
            if (organInjury.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return organInjury;
            }
        }
        System.out.println("ERROR: Przy metodzie getOrganInjuryFromPolish sprawdz czy taka nazwa istnieje! (checkOrganInjuryFromPolish)");
        return null;
    }
}
