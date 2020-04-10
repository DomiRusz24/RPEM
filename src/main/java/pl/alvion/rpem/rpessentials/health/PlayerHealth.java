package pl.alvion.rpem.rpessentials.health;

import pl.alvion.rpem.rpessentials.health.enums.BodyPart;
import pl.alvion.rpem.rpessentials.health.enums.Organ;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerBodyPart;
import pl.alvion.rpem.rpessentials.health.playerPart.PlayerOrgan;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

import java.util.ArrayList;


public class PlayerHealth {

    private RPPlayer rpPlayer;
    private ArrayList<PlayerBodyPart> playerBodyParts = new ArrayList<>();
    private ArrayList<PlayerOrgan> playerOrgans = new ArrayList<>();

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

    public PlayerOrgan getPlayerOrgan(Organ organ) {
        for(PlayerOrgan playerOrgan : this.getPlayerOrgans()) {
            if(playerOrgan.getOrgan().equals(organ)) {
                return playerOrgan;
            }
        }
        return PlayerOrgan.addPlayerOrgan(this.rpPlayer, organ);
    }

    public ArrayList<PlayerBodyPart> getPlayerBodyParts() {
        return playerBodyParts;
    }

    public ArrayList<PlayerOrgan> getPlayerOrgans() {
        return playerOrgans;
    }

    public RPPlayer getRpPlayer() {
        return rpPlayer;
    }
}
