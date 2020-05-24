package uk.co.ljefferies98.framework;

import java.util.concurrent.CopyOnWriteArraySet;

public class NodeManager {

    private CopyOnWriteArraySet<Node> nodes;

    public NodeManager() {
        this.nodes = new CopyOnWriteArraySet<>();
    }

    public NodeManager add(Node node) {
        nodes.add(node);
        return this;
    }

    public int execute(int loop) {
        for (Node node : nodes) {
            if(!node.validate())
                continue;
            node.execute();
            return loop;
        }
        return loop;
    }

}
