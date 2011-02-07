/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bukkit.mcnestbuilder;

import com.bukkit.mcnestbuilder.ai.PheromoneLevel;
import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.World;

/**
 *
 * @author covertcj
 */
public class WorldData {
    
    World world;

    HashMap<Location, PheromoneLevel> pheromoneLevels;
    
    public WorldData(World world) {
        this.world = world;

        this.pheromoneLevels = new HashMap<Location, PheromoneLevel>();
    }

    /**
     * Retrieves the material of a block a the given coordinates.
     *
     * @param x The x position of the block
     * @param y The y position of the block
     * @param z The z position of the block
     *
     * @return The block material
     */
    public Material getBlockType(int x, int y, int z) {
        return world.getBlockAt(x, y, z).getType();
    }

    public void setBlockType(int x, int y, int z, Material mat) {
        world.getBlockAt(x, y, z).setType(mat);
    }

    /**
     * Retrieves a reference to the pheromone data structure at the given block
     * coordinates.
     *
     * @param x The x position of the block
     * @param y The y position of the block
     * @param z The z position of the block
     *
     * @return The pheromones data structure
     */
    public PheromoneLevel getBlockPheromones(int x, int y, int z) {
        Location loc = new Location(x, y, z);
        PheromoneLevel pl = null;

        if (pheromoneLevels.containsKey(loc)) {
            pl = pheromoneLevels.get(loc);
        }
        else {
            pl = new PheromoneLevel();
            pheromoneLevels.put(loc, pl);
        }

        return pl;
    }

    /**
     * Retrieves the actual bukkit world used by the WorldData structure. This
     * should NOT be used in code, as it will break synchronization. It is
     * simply used to initialize the termite NPC's.
     *
     * @return The representation of the server world
     */
    public World getWorld() {
        return world;
    }
}
