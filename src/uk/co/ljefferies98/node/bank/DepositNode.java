package uk.co.ljefferies98.node.bank;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.commons.BankLocation;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.ui.Log;
import uk.co.ljefferies98.framework.Node;

public class DepositNode implements Node {

    private BankLocation bankLocation;

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        bankLocation = BankLocation.getNearest();
        if (!player.isAnimating() && !player.isMoving()) {
            if (Inventory.isFull()) {
                if (player.getPosition().distance(bankLocation.getPosition()) < 3) {
                    Log.info("Deposit Items");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void execute() {
        Bank.open(bankLocation);
        Time.sleep(Random.high(1000,2500));
        Bank.depositAll(1942);
        Time.sleep(Random.high(750,1500));
        Bank.close();
    }
}
