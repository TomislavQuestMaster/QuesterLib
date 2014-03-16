package net.thequester.processor;

import net.thequester.archiver.ArchiverException;
import net.thequester.archiver.QuestArchiver;
import net.thequester.model.*;
import net.thequester.model.Event.Event;
import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tdubravcevic
 */
public class QuestProcessor implements IQuestProcessor{

    private Quest quest;
    private EventProcessor eventProcessor;
	private Game game;

    public QuestProcessor(Quest quest, QuestArchive archive) {
        this.quest = quest;
		QuestArchiver archiver = new QuestArchiver(archive);
		try {
			this.game = archiver.loadGame("quest1");
		} catch (ArchiverException e) {
			this.game = new Game();
			this.game.setVisitedNodes(new LinkedList<Node>());
		}
	}

	@Override
	public Node processLocation(QuestLocation location) {

		for(Node node : getVisitableLocations(game.getCurrentNode())){

			if(isNodeAtLocation(node, location)){
				game.setCurrentNode(node);
				game.getVisitedNodes().add(node);
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

	@Override
	public Game getGame() {

		return game;
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
