package pl.alvion.rpem.rpessentials.health.playerPart.Interfaces;

import pl.alvion.rpem.rpessentials.health.enums.HealingStages;

public interface HealableInjury {
    int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    int healingLevelMin(); // Minimalny level leczenia
    void heal(HealingStages stage, double levelOfHealing); // Healuj po czesci, level healing daje w % efektywnosc healowania.
    void healFully(); // Healuj calkowicie
}
