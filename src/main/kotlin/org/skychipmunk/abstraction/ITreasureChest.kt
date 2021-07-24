package org.skychipmunk.abstraction

import org.bukkit.block.Block
import org.bukkit.entity.Player

interface ITreasureChest {

    fun Block.onInteracted(player: Player)

}