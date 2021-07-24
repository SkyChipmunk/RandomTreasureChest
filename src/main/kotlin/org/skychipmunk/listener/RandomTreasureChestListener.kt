package org.skychipmunk.listener

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.skychipmunk.data.treasurechest.CloseTreasureChest
import org.skychipmunk.util.getCloseChest
import org.skychipmunk.util.getTreasureChest
import org.skychipmunk.util.hasTreasureChest
import org.skychipmunk.util.isCloseChest

class RandomTreasureChestListener : Listener {

    @EventHandler
    fun PlayerInteractEvent.onPlayerInteractEvent() {
        if (action == Action.RIGHT_CLICK_BLOCK && clickedBlock.type == Material.CHEST) {
            if (clickedBlock.hasTreasureChest()) {
                with(clickedBlock.getTreasureChest()) {
                    clickedBlock.onInteracted(player)
                        if (clickedBlock.getTreasureChest()::class.java.isAssignableFrom(CloseTreasureChest::class.java)) {
                            if (clickedBlock.isCloseChest() && clickedBlock.getCloseChest()) {
                                isCancelled = true
                            }
                        }
                }

            }
        }

    }
}