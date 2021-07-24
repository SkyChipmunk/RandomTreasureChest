package org.skychipmunk.data.treasurechest

import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.skychipmunk.RandomTreasureChest
import org.skychipmunk.abstraction.ITreasureChest
import org.skychipmunk.util.getTime
import org.skychipmunk.util.setTime

class TimeBombTreasureChest: ITreasureChest {

    override fun Block.onInteracted(player: Player) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomTreasureChest.inst, Runnable {
            if (player.getTime() > 10000) {
                player.setTime()
                player.sendMessage("§c도망치세요 폭발 발동!")
                Bukkit.getScheduler().cancelTasks(RandomTreasureChest.inst)
            }
        },1L , 20L)
    }
}