package org.skychipmunk.util

import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue
import org.skychipmunk.RandomTreasureChest
import org.skychipmunk.abstraction.ITreasureChest
import org.skychipmunk.constant.RAGE
import java.util.*

private val random = Random()

fun Entity.getTreasureChestRage(): Location {
    return location.clone().add(
        (random.nextInt(RAGE + RAGE) - RAGE).toDouble(),
        random.nextInt(RAGE * 2).toDouble(),
        (random.nextInt(RAGE + RAGE) - RAGE).toDouble()
    )
}

fun Block.setTreasureChest(tc: ITreasureChest) {
    setMetadata("TreasureChest", FixedMetadataValue(RandomTreasureChest.inst, tc))
}

fun Block.getTreasureChest(): ITreasureChest {
    return getMetadata("TreasureChest")[0].value() as ITreasureChest
}

fun Block.hasTreasureChest(): Boolean {
    return hasMetadata("TreasureChest")
}

fun Player.getTime(): Long {
    if (!hasMetadata("Time")) {
        setTime()
    }
    return getMetadata("Time")[0].asLong()
}

fun Player.setTime() {
    setMetadata("Time", FixedMetadataValue(RandomTreasureChest.inst, System.currentTimeMillis()))

}

fun Block.closeChest() {
    setMetadata("Close", FixedMetadataValue(RandomTreasureChest.inst, true))
}

fun Block.isCloseChest(): Boolean {
    return hasMetadata("Close")
}

fun Block.openChest() {
    setMetadata("Close", FixedMetadataValue(RandomTreasureChest.inst, false))
}

fun Block.getCloseChest(): Boolean {
    if (!isCloseChest()) {
        openChest()
    }
    return getMetadata("Close")[0].asBoolean()

}