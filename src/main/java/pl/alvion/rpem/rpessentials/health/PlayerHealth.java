package pl.alvion.rpem.rpessentials.health;

import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;

public class PlayerHealth {

    private RPPlayer rpPlayer;
    private ArrayList<PlayerBodyPart> playerBodyParts = new ArrayList<>();

    PlayerHealth(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;
    }
}
