package uk.co.ljefferies98;

import org.rspeer.networking.dax.walker.DaxWalker;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.WebWalker;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import uk.co.ljefferies98.background.EnergyChecker;
import uk.co.ljefferies98.framework.NodeManager;
import uk.co.ljefferies98.node.NodeSupplier;


@ScriptMeta(developer = "ljefferies98", name = "Potato Picker", desc = "Picks Potatos", version = 0.025)
public class App extends Script {

    private NodeManager manager;
    private NodeSupplier supplier;

    @Override
    public void onStart() {
        super.onStart();

        Movement.setDefaultWebWalker(WebWalker.Dax);

        manager = new NodeManager();
        supplier = new NodeSupplier();

        setupNodes();
        setBackgroundTasks();
    }

    @Override
    public int loop() {
        return manager.execute(getLoopReturn());
    }

    private void setupNodes() {
        manager.add(supplier.WALK_TO_POTATO_FIELD);
        manager.add(supplier.HARVEST);
        manager.add(supplier.WALK_TO_BANK);
        manager.add(supplier.DEPOSIT);
    }

    private void setBackgroundTasks() {
        new EnergyChecker();
    }

    public static int getLoopReturn() {
        return Random.high(200, 450);
    }

}
