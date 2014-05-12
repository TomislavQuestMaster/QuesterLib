package net.thequester.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "game")
public class Game {

	@XmlElementWrapper(name = "visitedNodes")
	@XmlElement(name = "node", type = Integer.class)
    private List<Integer> visitedNodes;

    public Game(){
        this.visitedNodes = new ArrayList<Integer>();
    }

    public List<Integer> getVisitedNodes() {
        return visitedNodes;
    }

    public void setVisitedNodes(List<Integer> visitedNodes) {
        this.visitedNodes = visitedNodes;
    }

    public Integer currentNode() {

		if(visitedNodes.isEmpty()){
			return null;
		}

        return visitedNodes.get(visitedNodes.size()-1);
    }
}
