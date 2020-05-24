package uk.co.ljefferies98.node;

import uk.co.ljefferies98.framework.Node;
import uk.co.ljefferies98.node.bank.DepositNode;
import uk.co.ljefferies98.node.bank.WalkToBankNode;
import uk.co.ljefferies98.node.potato.HarvestNode;
import uk.co.ljefferies98.node.potato.WalkToPotatoNode;

public class NodeSupplier {

    public final Node WALK_TO_POTATO_FIELD = new WalkToPotatoNode();
    public final Node HARVEST = new HarvestNode();
    public final Node WALK_TO_BANK = new WalkToBankNode();
    public final Node DEPOSIT = new DepositNode();

}
