package org.skychipmunk.task

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.skychipmunk.data.TreasureChestData.treasureChestDatas
import org.skychipmunk.util.getTreasureChestRage
import org.skychipmunk.util.setTreasureChest
import java.util.*

class RandomTreasureChestTask : Runnable {

    private val random = Random()

    override fun run() {
        val locations = mutableListOf<Location>()
        Bukkit.getWorlds().forEach { world ->
            world.entities.filter { it !is Player }.forEach { entity ->
                locations.add(entity.getTreasureChestRage())
            }
        }
        val idx = random.nextInt(locations.size)
        val block = locations[idx].block
        block.type = Material.CHEST
        block.setTreasureChest(treasureChestDatas[random.nextInt(treasureChestDatas.size)])
        Bukkit.broadcastMessage("§a보물 상자가 생성되었습니다 좌표: ${block.location.x} , ${block.location.y} , ${block.location.z}")
        locations.removeAt(idx)
    }
}
