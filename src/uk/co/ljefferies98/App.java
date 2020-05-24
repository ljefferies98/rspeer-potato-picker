package uk.co.ljefferies98;

import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.WebWalker;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import uk.co.ljefferies98.background.EnergyChecker;
import uk.co.ljefferies98.framework.NodeManager;
import uk.co.ljefferies98.node.NodeSupplier;


@ScriptMeta(developer = "lewis12321", name = "Potato Farmer", desc = "Picks Potatos", version = 0.024)
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

    private void setBackgroundTasks() {
        new EnergyChecker();
    }

    private void setupNodes() {
        manager.add(supplier.WALK_TO_POTATO_FIELD);
        manager.add(supplier.HARVEST);
        manager.add(supplier.WALK_TO_BANK);
        manager.add(supplier.DEPOSIT);
    }

    @Override
    public int loop() {
        return manager.execute(getLoopReturn());
    }

    public static int getLoopReturn() {
        return Random.high(200, 450);
    }

}
