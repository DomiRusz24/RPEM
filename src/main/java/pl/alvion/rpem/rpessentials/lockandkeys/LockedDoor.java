package pl.alvion.rpem.rpessentials.lockandkeys;

import org.bukkit.block.Block;

import java.util.ArrayList;

public class LockedDoor {

    public static ArrayList<LockedDoor> lockedDoors = new ArrayList<>();

    private Block door;

    private Key key;


    public LockedDoor(Block door, Key key) {
        this.door = door;
        this.key = key;
        lockedDoors.add(this);
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public Block getDoor() {
        return door;
    }
}
