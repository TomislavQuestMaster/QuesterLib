package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tdubravcevic
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "quest")
public class Quest {

    private Integer id;

    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node", type = Node.class)
    private List<Node> nodes;

    private Map<Integer,Connection> connections;

    private Map<Integer, Event> events;

    public Quest() {
        this.nodes = new ArrayList<>();
        this.connections = new HashMap<>();
        this.events = new HashMap<>();
    }

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

    public Map<Integer, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<Integer, Event> events) {
        this.events = events;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
