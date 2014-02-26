package integration;

import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IQuestProcessor;
import net.thequester.processor.QuestProcessor;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
public class IntegrationTest {

	private IQuestProcessor processor;
	private Map<QuestLocation, Node> expectedPath;

	@Before
	public void setUp() throws JAXBException {

		JAXBContext jaxbContextMessage = JAXBContext.newInstance(Quest.class);
		Unmarshaller unmarshaller = jaxbContextMessage.createUnmarshaller();
		File file = new File(Paths.get("src/test/resources/quests/quest1/quest.xml").toUri());
		Quest quest = (Quest)unmarshaller.unmarshal(file);
		processor = new QuestProcessor(quest);

		expectedPath = new LinkedHashMap<QuestLocation, Node>();
		expectedPath.put(new QuestLocation(1.0,1.0), quest.getNodes().get(1));
		expectedPath.put(new QuestLocation(1.0,1.0), null);
		expectedPath.put(new QuestLocation(3.0,3.0), quest.getNodes().get(3));
	}

	@Test
	public void runQuest(){

		for(QuestLocation location : expectedPath.keySet()){

			Node node = processor.processLocation(location);
			assertEquals(expectedPath.get(location), node);
		}
	}
}
