package pl.alvion.rpem.rpessentials.health_dr.enums;

public enum BodyPart {
    LeftArm("LewaReka", 0),
    RightArm("PrawaReka", 1),
    LeftLeg("LewaNoga", 2),
    RightLeg("PrawaNoga", 3),
    LeftHand("LewaReka", 4),
    RightHand("PrawaReka", 5),
    LeftFoot("LewaStopa", 6),
    RightFoot("PrawaStopa", 7),
    Chest("Klata", 8),
    Head("Glowa", 9),
    Neck("Szyja", 10),
    LeftEye("LeweOko", 11),
    RightEye("PraweOko", 12),
    Brain("Mozg", 13),
    Heart("Serce", 14),
    Lungs("Pluca", 15),
    Stomach("Zoladek", 16);


    protected String PolishIdentification;
    protected int id;

    BodyPart(String PolishIdentification, int id) {
        this.PolishIdentification = PolishIdentification;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPolishIdentification() {
        return PolishIdentification;
    }

    public static Boolean checkBodyPartFromID(int id) {
        for (BodyPart bodyPart : BodyPart.values()) {
            if (bodyPart.id == id) {
                return true;
            }
        }
        return false;
    }

    public static BodyPart getBodyPartFromID(int id) {
        for (BodyPart bodyPart : BodyPart.values()) {
            if (bodyPart.id == id) {
                return bodyPart;
            }
        }
        System.out.println("ERROR: Przy metodzie getBodyPartFromID sprawdz czy takie ID istnieje! (checkBodyPartFromID)");
        return null;
    }

    public static Boolean checkBodyPartFromPolish(String polishIdentification) {
        for (BodyPart bodyPart : BodyPart.values()) {
            if (bodyPart.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return true;
            }
        }
        return false;
    }

    public static BodyPart getBodyPartFromPolish(String polishIdentification) {
        for (BodyPart bodyPart : BodyPart.values()) {
            if (bodyPart.PolishIdentification.equalsIgnoreCase(polishIdentification)) {
                return bodyPart;
            }
        }
        System.out.println("ERROR: Przy metodzie getBodyPartFromPolish sprawdz czy taka nazwa istnieje! (checkBodyPartFromPolish)");
        return null;
    }
}
