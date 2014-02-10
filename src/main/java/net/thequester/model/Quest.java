package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author tdubravcevic
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "quest")
public class Quest {

    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node", type = Node.class)
    private List<Node> nodes;

    Map<Integer,Connection> connections;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Map<Integer, Connection> getConnections() {
        return connections;
    }

    public void setConnections(Map<Integer, Connection> connections) {
        this.connections = connections;
    }

}
