package net.thequester.processor;

import net.thequester.model.Node;
import net.thequester.model.QuestLocation;
import net.thequester.processor.impl.EventProcessor;
import net.thequester.processor.impl.GameEngine;
import net.thequester.processor.impl.QuestProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author tdubravcevic
 */
public class GameEngineTest {

	private GameEngine engine;
	private QuestProcessor questProcessor = mock(QuestProcessor.class);
	private EventProcessor eventProcessor = mock(EventProcessor.class);

	QuestLocation location;

	@Before
	public void setUp() {

		engine = new GameEngine(questProcessor, eventProcessor);
	}

	@Test
	public void test() {

		location = new QuestLocation(1.0, 1.0);

		method();
		method1();

		engine.processLocation(location);

	}

	private void method() {

		Node node = new Node();
		node.setId(2);

		when(questProcessor.processLocation(null, location)).thenReturn(node);
	}
	private void method1() {

		when(eventProcessor.isCauseFulfilled(2, new HashMap<Integer, Integer>())).thenReturn(true);
	}

}
