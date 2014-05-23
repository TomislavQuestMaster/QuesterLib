package net.thequester.processor;

import com.google.common.base.Optional;
import net.thequester.model.Node;
import net.thequester.model.QuestLocation;
import net.thequester.processor.impl.EventProcessor;
import net.thequester.processor.impl.GameEngine;
import net.thequester.processor.impl.QuestProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author tdubravcevic
 */
public class GameEngineTest {

	private GameEngine engine;
	private final QuestProcessor questProcessor = mock(QuestProcessor.class);
	private final EventProcessor eventProcessor = mock(EventProcessor.class);

	private QuestLocation location;
	private Integer currentNode;


	@Before
	public void setUp() {

		engine = new GameEngine(questProcessor, eventProcessor);
	}

	@Test
	public void happyPath() {

		location = new QuestLocation(1.0, 1.0);

		givenCurrent(null);
		givenNodeFromProcessor(1);
		givenSuccessfulEvent();

		whenEngineProcessesLocation();

		thenIsInPath(1);
	}

	@Test
	public void eventFails() {

		location = new QuestLocation(1.0, 1.0);

		givenCurrent(null);
		givenNodeFromProcessor(1);
		givenUnSuccessfulEvent();

		whenEngineProcessesLocation();

		thenIsNotInPath(1);
	}

	private void whenEngineProcessesLocation() {

		engine.processLocation(location);
	}

	private void givenCurrent(Integer node){
		currentNode = node;
	}

	private void givenNodeFromProcessor(Integer id){
		Node node = new Node();
		node.setId(id);
		when(questProcessor.processLocation(currentNode, location)).thenReturn(Optional.of(node));
	}

	private void givenSuccessfulEvent() {

		when(eventProcessor.isCauseFulfilled(anyInt(), eq(new HashMap<Integer, Integer>()))).thenReturn(true);
	}

	private void givenUnSuccessfulEvent() {

		when(eventProcessor.isCauseFulfilled(anyInt(), eq(new HashMap<Integer, Integer>()))).thenReturn(false);
	}

	private void thenIsInPath(Integer node){

		assertTrue(engine.getGamePath().contains(node));
	}

	private void thenIsNotInPath(Integer node){

		assertFalse(engine.getGamePath().contains(node));
	}

}
