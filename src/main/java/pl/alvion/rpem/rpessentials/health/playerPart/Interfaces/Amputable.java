package pl.alvion.rpem.rpessentials.health.playerPart.Interfaces;

public interface Amputable {
    double amputationSuccessChance(); // 0.1 - 1;
    double amputationInfectionChance(); // 0.1 - 1;
    void onAmputate();
}
