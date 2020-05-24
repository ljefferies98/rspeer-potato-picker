package uk.co.ljefferies98.node.bank;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.commons.BankLocation;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.ui.Log;
import uk.co.ljefferies98.framework.Node;

public class WalkToBankNode implements Node {

    private BankLocation bank;

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        bank = BankLocation.getNearest();
        if (!player.isAnimating() && Inventory.isFull()) {
            if (player.getPosition().distance(bank.getPosition()) > 3) {
                Log.info("Walking to Bank");
                return true;
            }
        }
        return false;
    }

    @Override
    public void execute() {
        Time.sleepUntil(() -> Movement.walkToRandomized(bank.getPosition()), 5000);
    }
}
