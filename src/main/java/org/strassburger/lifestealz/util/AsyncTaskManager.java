package org.strassburger.lifestealz.util;

import com.tcoded.folialib.wrapper.task.WrappedTask;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all running async tasks
 */
public final class AsyncTaskManager {
    private final List<BukkitTask> runningTasks = new ArrayList<>();
    private final List<WrappedTask> wrappedTasks = new ArrayList<>();

    /**
     * Add a task to the list of running tasks
     * @param task The task to add
     */
    public void addTask(BukkitTask task) {
        runningTasks.add(task);
    }

    public void addWrappedTask(WrappedTask task) {
        wrappedTasks.add(task);
    }

    /**
     * Cancel all running tasks
     */
    public void cancelAllTasks() {
        for (BukkitTask task : runningTasks) {
            if (task.isCancelled()) continue;
            task.cancel();
        }
        runningTasks.clear();
    }

    public void cancelAllWrappedTasks() {
        for (WrappedTask wrappedTask : wrappedTasks) {
            if (wrappedTask.isCancelled()) continue;
            wrappedTask.cancel();
        }
        runningTasks.clear();
    }
}
