package org.skychipmunk.data.treasurechest

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.skychipmunk.abstraction.ITreasureChest

class OpenTreasureChest: ITreasureChest {

    override fun Block.onInteracted(player: Player) {
        player.inventory.addItem(ItemStack(Material.EMERALD))
        player.sendMessage("§a보물상자 오픈 축하드립니다.!")
        type = Material.AIR
    }
}