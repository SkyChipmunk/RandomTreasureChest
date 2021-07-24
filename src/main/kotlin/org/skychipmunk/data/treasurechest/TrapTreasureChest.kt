package org.skychipmunk.data.treasurechest

import org.bukkit.Sound
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.skychipmunk.abstraction.ITreasureChest

class TrapTreasureChest: ITreasureChest {

    override fun Block.onInteracted(player: Player) {
        player.playSound(player.location , Sound.ENTITY_PLAYER_LEVELUP , 1f , 1f)
        location.world.createExplosion(location , 10f)
    }
}