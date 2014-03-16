package net.thequester.processor.impl;

import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IQuestProcessor;

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
	public Node processLocation(Integer lastId, QuestLocation location) {

        Node currentNode = quest.getNodes().get(lastId);

		for(Node node : getVisitableLocations(currentNode)){

			if(isNodeAtLocation(node, location)){
				return node;
			}
		}

		return null;
	}

    @Override
    public List<Node> getChildren(Node node){

        List<Node> children = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getChildren()){
             children.add(quest.getNodes().get(nodeId));
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

	private List<Node> getVisitableLocations(Node node){

		if(node == null){
			List<Node> nodes = new ArrayList<Node>();
			nodes.add(quest.getNodes().get(0));
			return nodes;
		}

		return getChildren(node);
	}

    boolean isNodeAtLocation(Node node, QuestLocation location){

        return distanceInMeters(node.getQuestLocation(), location) <= node.getRadius();
    }

	private double distanceInMeters(QuestLocation to, QuestLocation from) {

        double pk = 180 / Math.PI;

        double a1 = to.getLatitude() * Math.PI / 180;
        double a2 = to.getLongitude() * Math.PI / 180;
        double b1 = from.getLatitude() * Math.PI / 180;
        double b2 = from.getLongitude() * Math.PI / 180;

        double t = Math.sin(a1)*Math.sin(b1) + Math.cos(a1)*Math.cos(b1)*Math.cos(a2 - b2);
        double tt = Math.acos(t);

        return 6366000 * tt;
	}

}