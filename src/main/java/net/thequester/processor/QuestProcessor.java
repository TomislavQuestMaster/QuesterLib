package net.thequester.processor;

import net.thequester.model.Event.Event;
import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tdubravcevic
 */
public class QuestProcessor {

    private Quest quest;
    private EventProcessor eventProcessor;

    public QuestProcessor(Quest quest) {
        this.quest = quest;
    }

    /**
     * @param node currently visited node
     * @return list of nodes you can go to from the current
     */
    public List<Node> getChildren(Node node){

        List<Node> children = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getChildren()){
             children.add(quest.getNodes().get(nodeId));
        }

        return children;
    }

    /**
     * @param node currently visited node
     * @return list of nodes from which you can visit the current node
     */
    public List<Node> getParents(Node node){

        List<Node> parents = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getParents()){
            parents.add(quest.getNodes().get(nodeId));
        }

        return parents;
    }


    public boolean isNodeAtLocation(Node node, QuestLocation location){

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

    public Node gotoNext(Game game) {

        for(Node child : getChildren(game.getCurrentNode())){

            if(isNodeAtLocation(child,game.getCurrentLocation())){
                return child;
            }

        }
        return null;
    }


    public Node processLocation(Node currentNode, QuestLocation location) {

        Event event = quest.getEvents().get(currentNode.getId());
        EventProcessor processor = new EventProcessor(event);

        List<Node> children = getChildren(currentNode);

        if(eventProcessor.isCauseFulfilled(game)){
            eventProcessor.applyEffect(children);
        }


        return null;
    }
}
