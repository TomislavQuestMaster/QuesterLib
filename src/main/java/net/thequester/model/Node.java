package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tdubravcevic
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "node")
public class Node {

    private Integer id;
    private QuestLocation questLocation;
    private Double radius;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestLocation getQuestLocation() {
        return questLocation;
    }

    public void setQuestLocation(QuestLocation questLocation) {
        this.questLocation = questLocation;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
