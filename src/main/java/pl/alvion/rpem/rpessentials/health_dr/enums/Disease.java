package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum Disease {

    test("test", 1, DiseaseTypes.Bacteria);



    protected String PolishIdentification;
    protected int id;
    protected DiseaseTypes type;

    Disease(String PolishIdentification, int id, DiseaseTypes type) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public DiseaseTypes getType() {
        return type;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkInfectionFromID(int id) {
        for (Disease disease : Disease.values()) {
            if (disease.id == id) {
                return true;
            }
        }
        return false;
    }

    public static Disease getInfectionFromID(int id) {
        for (Disease disease : Disease.values()) {
            if (disease.id == id) {
                return disease;
            }
        }
        System.out.println("ERROR: Przy metodzie getInfectionFromID sprawdz czy takie ID istnieje! (checkInfectionFromID)");
        return null;
    }

    public static Boolean checkInfectionFromPolish(String polishIdentification) {
        for (Disease disease : Disease.values()) {
            if (disease.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static Disease getInfectionFromPolish(String polishIdentification) {
        for (Disease disease : Disease.values()) {
            if (disease.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return disease;
            }
        }
        System.out.println("ERROR: Przy metodzie getInfectionFromPolish sprawdz czy taka nazwa istnieje! (checkInfectionFromPolish)");
        return null;
    }
}
