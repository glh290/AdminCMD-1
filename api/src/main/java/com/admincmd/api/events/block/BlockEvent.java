package com.admincmd.api.events.block;

import com.admincmd.api.block.Block;
import com.admincmd.api.events.Event;


public interface BlockEvent extends Event {

    /**
     * Get the block
     *  
     * @return
     */
    public Block getBlock();

    /**
     * Set the block
     *
     * @param b
     */
    public void setBlock(Block b);
    
}
