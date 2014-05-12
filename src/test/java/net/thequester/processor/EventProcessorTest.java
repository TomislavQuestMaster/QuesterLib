package net.thequester.processor;

import net.thequester.model.Event;
import net.thequester.processor.impl.EventProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author tdubravcevic
 */
public class EventProcessorTest {

	private EventProcessor processor;

	private Map<Integer, Event> events;
	private Map<Integer, Integer> state;
	private boolean result;

	@Before
	public void setUp() {

		events = new HashMap<Integer, Event>();
		state = new HashMap<Integer, Integer>();

		processor = new EventProcessor(events);
	}

	@Test
	public void ifNoEventsCauseIsFulfilled(){

		whenProcessing(0);
		thenCauseFulfilled();
	}

	@Test
	public void ifNoEventForNodeCauseIsFulfilled(){

		givenEvent(2, new Event.EventBuilder().build());
		whenProcessing(1);
		thenCauseFulfilled();
	}

	@Test
	public void causeCanBeUnvisited() {

		givenEvent(2, new Event.EventBuilder().cause(1, 0).build());
		whenProcessing(2);

		thenCauseFulfilled();
	}

	@Test
	public void causeNotFulfilled() {

		givenEvent(2, new Event.EventBuilder().cause(1, 2).build());
		givenCause(1, 1);
		whenProcessing(2);

		thenCauseNotFulfilled();
	}

	@Test
	public void happyPath() {

		givenEvent(3, new Event.EventBuilder().cause(1, 1).cause(2, 1).build());
		givenCause(1, 1);
		givenCause(2, 1);

		whenProcessing(3);

		thenCauseFulfilled();
	}

	private void givenEvent(Integer at, Event event) {

		events.put(at, event);
	}

	private void givenCause(Integer visited, Integer times) {

		state.put(visited, times);
	}

	private void whenProcessing(Integer node){
		result = processor.isCauseFulfilled(node, state);
	}

	private void thenCauseFulfilled(){
		assertTrue(result);
	}

	private void thenCauseNotFulfilled(){
		assertFalse(result);
	}
}
