package com.admincmd.events.block;

import com.admincmd.entity.Player;

public interface BlockPlaceEvent extends BlockEvent {

    /**
     * Get the player who placed the block
     *
     * @return
     */
    public Player getPlayer();
    
}
