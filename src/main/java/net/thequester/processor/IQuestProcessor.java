package net.thequester.processor;

import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.QuestLocation;

import java.util.List;

/**
 * @author tdubravcevic
 */
public interface IQuestProcessor {

	/**
	 * verifies if the new location is in any new node radius
	 * @param location new visited location
	 * @return new questNode if one is discovered, null otherwise
	 */
	Node processLocation(QuestLocation location);

	/**
	 * @param node currently visited node
	 * @return list of nodes you can go to from the current
	 */
	List<Node> getChildren(Node node);

	/**
	 * @param node currently visited node
	 * @return list of nodes from which you can visit the current node
	 */
	List<Node> getParents(Node node);

	Game getGame();
}
