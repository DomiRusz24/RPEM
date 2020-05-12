package pl.alvion.rpem.rpessentials.health_dr;

import pl.alvion.rpem.rpessentials.health_dr.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.health_dr.playerPart.PlayerDisease;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;

import java.util.ArrayList;


public class PlayerHealth {

    private RPPlayer rpPlayer;
    private ArrayList<PlayerBodyPart> playerBodyParts = new ArrayList<>();
    private ArrayList<PlayerDisease> infenctions = new ArrayList<>();

    public PlayerHealth(RPPlayer rpPlayer) {
        this.rpPlayer = rpPlayer;
    }

    public PlayerBodyPart getBodyPart(BodyPart bodyPart) {
        for(PlayerBodyPart playerBodyPart : this.playerBodyParts) {
            if(playerBodyPart.getBodyPart().equals(bodyPart)) {
                return playerBodyPart;
            }
        }
        return PlayerBodyPart.addPlayerBodyPart(rpPlayer, bodyPart);
    }

    public ArrayList<PlayerBodyPart> getPlayerBodyParts() {
        return playerBodyParts;
    }

    public ArrayList<PlayerDisease> getInfenctions() {
        return infenctions;
    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }
}
