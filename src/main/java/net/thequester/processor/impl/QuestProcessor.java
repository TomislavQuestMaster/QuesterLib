package net.thequester.processor.impl;

import com.google.common.base.Optional;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IQuestProcessor;
import net.thequester.utility.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tdubravcevic
 */
public class QuestProcessor implements IQuestProcessor {

    private Quest quest;

    public QuestProcessor(Quest quest) {
        this.quest = quest;
	}

	@Override
	public Optional<Node> processLocation(Integer lastId, QuestLocation location) {

        Node currentNode = getNodeById(lastId);

		for(Node node : getVisitableLocations(currentNode)){

			if(isNodeAtLocation(node, location)){
				return Optional.of(node);
			}
		}
		return Optional.absent();
	}

    private Node getNodeById(int id){

        for(Node node : quest.getNodes()){
            if(node.getId() == id){
                return node;
            }
        }
        return null;
    }

    private List<Node> getVisitableLocations(Node node){

        if(node == null){
            List<Node> nodes = new ArrayList<Node>();
            nodes.add(quest.getNodes().get(0));
            return nodes;
        }

        return getChildren(node);
    }

    private boolean isNodeAtLocation(Node node, QuestLocation location){

        return Utility.distanceInMeters(node.getQuestLocation(), location) <= node.getRadius();
    }

    @Override
    public List<Node> getChildren(Node node){

        List<Node> children = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getChildren()){
             children.add(getNodeById(nodeId));
        }

        return children;
    }

    @Override
    public List<Node> getParents(Node node){

        List<Node> parents = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getParents()){
            parents.add(quest.getNodes().get(nodeId));
        }

        return parents;
    }

}
