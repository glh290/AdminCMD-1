package com.admincmd.api.events.block;

import com.admincmd.api.entity.Player;


public interface BlockPlaceEvent extends BlockEvent {

    /**
     * Get the player who placed the block
     *
     * @return
     */
    public Player getPlayer();
    
}
