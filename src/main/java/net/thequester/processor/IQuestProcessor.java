package net.thequester.processor;

import com.google.common.base.Optional;
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
     * @param lastId last visited node
	 * @param location new visited location
	 * @return optional inside who is a new questNode if one is discovered, nothing otherwise
	 */
     Optional<Node> processLocation(Integer lastId, QuestLocation location);

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

}
