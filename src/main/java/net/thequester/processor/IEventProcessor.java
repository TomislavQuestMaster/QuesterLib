package net.thequester.processor;

import net.thequester.model.Node;
import java.util.Map;

/**
 * Created by Tomo.
 */
public interface IEventProcessor {

	/**
	 * verifies if the event should be triggered
	 * @param newNode node that the user is currently at
	 * @param nodeStates map with number of visits for node
	 * @return true if the node states match the wanted event, false otherwise
	 */
    boolean isCauseFulfilled(Integer newNode, Map<Integer, Integer> nodeStates);
}
