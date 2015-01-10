package com.admincmd.events.block;

import com.admincmd.block.Block;
import com.admincmd.events.Event;

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
