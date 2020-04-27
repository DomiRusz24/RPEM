package pl.alvion.rpem.rpessentials.lockandkeys_dr;

import org.bukkit.block.Block;

import java.util.ArrayList;

public class LockedDoor {

    public static ArrayList<LockedDoor> lockedDoors = new ArrayList<>();

    private Block door;

    private ArrayList<Key> keys = new ArrayList<>();


    public LockedDoor(Block door) {
        this.door = door;
    }

    public void addKey(Key key) {

    }

    public Block getDoor() {
        return door;
    }
}
