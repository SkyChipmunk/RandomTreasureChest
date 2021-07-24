package org.skychipmunk

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.skychipmunk.listener.RandomTreasureChestListener
import org.skychipmunk.task.RandomTreasureChestTask

class RandomTreasureChest : JavaPlugin() {

    companion object {
        lateinit var inst: JavaPlugin
    }

    override fun onEnable() {
        inst = this
        Bukkit.getPluginManager().registerEvents(RandomTreasureChestListener(), this)
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, RandomTreasureChestTask(), 1L, 600L)
    }
}