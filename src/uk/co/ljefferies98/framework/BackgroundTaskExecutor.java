package uk.co.ljefferies98.framework;

import com.acuitybotting.common.utils.ExecutorUtil;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackgroundTaskExecutor {

    private static ScheduledExecutorService executor;

    private static ScheduledExecutorService getExecutor() {
        if(executor == null) {
            executor = ExecutorUtil.newScheduledExecutorPool(1, Throwable::printStackTrace);
        }
        return executor;
    }

    public static void submit(Runnable runnable, long loop) {
        getExecutor().scheduleAtFixedRate(runnable, 0, loop, TimeUnit.MILLISECONDS);
    }

    public static void shutdown() {
        getExecutor().shutdown();
    }
}