package de.sldk.mc.metrics;

import io.prometheus.client.Collector;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public abstract class WorldMetric extends Metric {

    public WorldMetric(Plugin plugin, Collector collector) {
        super(plugin, collector);
    }

    @Override
    public final void doCollect() {
        clear();
        for (World world : Bukkit.getWorlds()) {
            collect(world);
        }
    }

    protected abstract void clear();
    protected abstract void collect(World world);

    protected String getEntityName(EntityType type) {
        return type.name();
    }
}
