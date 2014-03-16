package net.thequester.processor;

import net.thequester.model.Node;
import java.util.Map;

/**
 * Created by Tomo.
 */
public interface IEventProcessor {

    boolean isCauseFulfilled(Integer newNode, Map<Integer, Integer> nodeStates);
}
