package pl.alvion.rpem.rpessentials.health.playerPart.Interfaces;

import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;

public interface InfectableInjury {
    double infectSeverity(); // Sila Skala od 0.1 - 1
    double infectChance(); // Szansa skala od 0.1 - 10
}
