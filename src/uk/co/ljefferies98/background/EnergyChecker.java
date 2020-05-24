package uk.co.ljefferies98.background;

import org.rspeer.runetek.api.movement.Movement;
import uk.co.ljefferies98.framework.BackgroundTaskExecutor;

import java.util.concurrent.ThreadLocalRandom;

public class EnergyChecker {

    public EnergyChecker() {
        BackgroundTaskExecutor.submit(checkEnergy, 30000);
    }

    private Runnable checkEnergy = () -> {
        int currentEnergy = Movement.getRunEnergy();
        int toggleEnergyLimit = ThreadLocalRandom.current().nextInt(20, 30 + 1);
        if(currentEnergy > toggleEnergyLimit && !Movement.isRunEnabled()){
            Movement.toggleRun(true);
        }
    };

}
