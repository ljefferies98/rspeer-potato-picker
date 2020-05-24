package uk.co.ljefferies98.node.potato;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.ui.Log;
import uk.co.ljefferies98.area.potato.Field;
import uk.co.ljefferies98.framework.Node;

public class HarvestNode implements Node {

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        if (!player.isAnimating() && !player.isMoving()) {
            if (!Inventory.isFull()) {
                if (Field.POTATO_FIELD.contains(player.getPosition())) {
                    Log.info("Picking Potato: " + (Inventory.getCount() + 1));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void execute() {
        SceneObject potato = SceneObjects.getNearest(s -> s.getId() == 312);
        potato.interact("Pick");
        Time.sleep(Random.high(1500,2500));
    }
}
