package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum DiseaseContagiusType {

    OnTouch("test", 1);

    protected String PolishIdentification;
    protected int id;

    DiseaseContagiusType(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkDiseaseContagiusTypeFromID(int id) {
        for (DiseaseContagiusType DiseaseContagiusType : DiseaseContagiusType.values()) {
            if (DiseaseContagiusType.id == id) {
                return true;
            }
        }
        return false;
    }

    public static DiseaseContagiusType getDiseaseContagiusTypeFromID(int id) {
        for (DiseaseContagiusType DiseaseContagiusType : DiseaseContagiusType.values()) {
            if (DiseaseContagiusType.id == id) {
                return DiseaseContagiusType;
            }
        }
        System.out.println("ERROR: Przy metodzie getDiseaseContagiusTypeFromID sprawdz czy takie ID istnieje! (checkDiseaseContagiusTypeFromID)");
        return null;
    }

    public static Boolean checkDiseaseContagiusTypeFromPolish(String polishIdentification) {
        for (DiseaseContagiusType DiseaseContagiusType : DiseaseContagiusType.values()) {
            if (DiseaseContagiusType.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static DiseaseContagiusType getDiseaseContagiusTypeFromPolish(String polishIdentification) {
        for (DiseaseContagiusType DiseaseContagiusType : DiseaseContagiusType.values()) {
            if (DiseaseContagiusType.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return DiseaseContagiusType;
            }
        }
        System.out.println("ERROR: Przy metodzie getDiseaseContagiusTypeFromPolish sprawdz czy taka nazwa istnieje! (checkDiseaseContagiusTypeFromPolish)");
        return null;
    }
}
