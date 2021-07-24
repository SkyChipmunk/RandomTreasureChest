package org.skychipmunk.data

import org.skychipmunk.data.treasurechest.CloseTreasureChest
import org.skychipmunk.data.treasurechest.OpenTreasureChest
import org.skychipmunk.data.treasurechest.TimeBombTreasureChest
import org.skychipmunk.data.treasurechest.TrapTreasureChest

object TreasureChestData {

    val treasureChestDatas = listOf(CloseTreasureChest(), OpenTreasureChest(), TimeBombTreasureChest(), TrapTreasureChest())
}