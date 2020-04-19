package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum DiseaseTypes {

    Bacteria("Bakteria", 0),
    Virus("Wirus", 1);


    protected String PolishIdentification;
    protected int id;

    DiseaseTypes(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkInfectionTypeFromID(int id) {
        for (DiseaseTypes DiseaseTypes : DiseaseTypes.values()) {
            if (DiseaseTypes.id == id) {
                return true;
            }
        }
        return false;
    }

    public static DiseaseTypes getInfectionTypeFromID(int id) {
        for (DiseaseTypes DiseaseTypes : DiseaseTypes.values()) {
            if (DiseaseTypes.id == id) {
                return DiseaseTypes;
            }
        }
        System.out.println("ERROR: Przy metodzie getInfectionTypeFromID sprawdz czy takie ID istnieje! (checkInfectionTypeFromID)");
        return null;
    }

    public static Boolean checkInfectionTypeFromPolish(String polishIdentification) {
        for (DiseaseTypes DiseaseTypes : DiseaseTypes.values()) {
            if (DiseaseTypes.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static DiseaseTypes getInfectionTypeFromPolish(String polishIdentification) {
        for (DiseaseTypes DiseaseTypes : DiseaseTypes.values()) {
            if (DiseaseTypes.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return DiseaseTypes;
            }
        }
        System.out.println("ERROR: Przy metodzie getInfectionTypeFromPolish sprawdz czy taka nazwa istnieje! (checkInfectionTypeFromPolish)");
        return null;
    }
}
