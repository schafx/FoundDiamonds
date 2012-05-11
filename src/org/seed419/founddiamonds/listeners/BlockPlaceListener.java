/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.seed419.founddiamonds.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.seed419.founddiamonds.ListHandler;
import org.seed419.founddiamonds.Node;
import org.seed419.founddiamonds.FoundDiamonds;

/**
 *
 * @author seed419
 */
public class BlockPlaceListener implements Listener {


    private FoundDiamonds fd;


    public BlockPlaceListener(FoundDiamonds fd) {
        this.fd = fd;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        for (Node x : ListHandler.getBroadcastedBlocks()) {
            if (x.getMaterial() == event.getBlockPlaced().getType()) {
                fd.addToPlacedBlocks(event.getBlock().getLocation());
            }
        }
    }
}