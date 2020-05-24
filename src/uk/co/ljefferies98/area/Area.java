package uk.co.ljefferies98.area;

import org.rspeer.runetek.api.movement.position.Position;

public class Area {

    public static final org.rspeer.runetek.api.movement.position.Area POTATO_FIELD = org.rspeer.runetek.api.movement.position.Area.polygonal(
            new Position[]{
                    new Position(3241, 3299, 0),
                    new Position(3241, 3304, 0),
                    new Position(3259, 3322, 0),
                    new Position(3267, 3322, 0),
                    new Position(3267, 3298, 0),
                    new Position(3265, 3298, 0),
                    new Position(3264, 3299, 0),
                    new Position(3262, 3299, 0),
                    new Position(3261, 3300, 0),
                    new Position(3257, 3300, 0),
                    new Position(3256, 3299, 0),
                    new Position(3241, 3299, 0)
            }
    );

    public static final org.rspeer.runetek.api.movement.position.Area POTATO_FIELD_NORTH = org.rspeer.runetek.api.movement.position.Area.polygonal(
            new Position[]{
                    new Position(3259, 3320, 0),
                    new Position(3266, 3320, 0),
                    new Position(3266, 3316, 0),
                    new Position(3255, 3316, 0)
            }
    );

    public static final org.rspeer.runetek.api.movement.position.Area POTATO_FIELD_SOUTH = org.rspeer.runetek.api.movement.position.Area.polygonal(
            new Position[]{
                    new Position(3242, 3300, 0),
                    new Position(3242, 3303, 0),
                    new Position(3246, 3307, 0),
                    new Position(3246, 3300, 0)
            }
    );

}
