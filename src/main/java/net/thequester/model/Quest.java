package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author tdubravcevic
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "quest")
public class Quest {

    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node", type = Node.class)
    private List<Node> nodes;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
