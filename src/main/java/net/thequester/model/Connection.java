package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author tdubravcevic
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "children", "parents" })
@XmlRootElement(name = "connections")
public class Connection {

    @XmlElement(name = "child", type = Integer.class)
    private List<Integer> children;
    @XmlElement(name = "parent", type = Integer.class)
    private List<Integer> parents;

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    public List<Integer> getParents() {
        return parents;
    }

    public void setParents(List<Integer> parents) {
        this.parents = parents;
    }
}
