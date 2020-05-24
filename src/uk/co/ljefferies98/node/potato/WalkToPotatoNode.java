package uk.co.ljefferies98.node.potato;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.movement.position.Position;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.ui.Log;
import uk.co.ljefferies98.area.potato.Field;
import uk.co.ljefferies98.framework.Node;

import java.util.List;

public class WalkToPotatoNode implements Node {

    private Position position;

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        if (!player.isAnimating() && !Inventory.isFull()) {
            if (!Field.POTATO_FIELD.contains(player.getPosition())) {
                selectRandomTile();
                Log.info("Walking to Potato Field");
                return true;
            }
        }
        position = null;
        return false;
    }

    @Override
    public void execute() {
        Movement.walkTo(position);
    }

    private void selectRandomTile() {
        if (position != null) {
            return;
        }

        Player player = Players.getLocal();
        Area area = Field.POTATO_FIELD_NORTH;

        double northDist = player.distance(Field.POTATO_FIELD_NORTH.getCenter());
        double southDist = player.distance(Field.POTATO_FIELD_SOUTH.getCenter());

        if (southDist < northDist) area = Field.POTATO_FIELD_SOUTH;

        List<Position> positions = area.getTiles();
        position = positions.get(Random.nextInt(positions.size()));
    }

}
