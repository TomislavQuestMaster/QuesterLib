package net.thequester.processor;

import net.thequester.model.Node;
import net.thequester.model.QuestLocation;

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
}
