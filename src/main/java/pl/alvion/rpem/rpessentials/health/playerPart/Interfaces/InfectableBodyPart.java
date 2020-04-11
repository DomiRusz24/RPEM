package pl.alvion.rpem.rpessentials.health.playerPart.Interfaces;

public interface InfectableBodyPart {
    double infectSeverity(); // Sila Skala od 0.1 - 1
    void onInfect(double strength); // Infekcja
}
