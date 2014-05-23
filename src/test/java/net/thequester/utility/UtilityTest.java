package net.thequester.utility;

import net.thequester.model.QuestLocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
public class UtilityTest {

	@Test
	public void distanceIsCorrect(){

		QuestLocation to = new QuestLocation(0.0,0.0);
		QuestLocation from = new QuestLocation(1.0,1.0);

		assertEquals(8122744, Utility.distanceInMeters(to, from), 0.01);
	}
}
