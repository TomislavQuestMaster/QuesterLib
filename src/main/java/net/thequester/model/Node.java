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

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Node node = (Node) o;

		if (!id.equals(node.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		return id.hashCode();
	}
}
