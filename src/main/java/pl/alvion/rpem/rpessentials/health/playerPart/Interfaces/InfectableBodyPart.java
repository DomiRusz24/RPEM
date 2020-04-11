package pl.alvion.rpem.rpessentials.health.playerPart.Interfaces;

public interface InfectableBodyPart {
    double infectSeverity(); // Sila Skala od 0.1 - 1
    void onInfectStage1(double strength); // Infekcja 1
    void onInfectStage2(double strength); // Infekcja 2
    void onInfectStage3(double strength); // Infekcja 3
    void onInfectStage4(double strength); // Infekcja 4
}
