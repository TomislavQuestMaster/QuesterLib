package integration;

import net.thequester.archiver.ArchiverException;
import net.thequester.archiver.QuestArchiver;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestArchive;
import net.thequester.model.QuestLocation;
import net.thequester.processor.IQuestProcessor;
import net.thequester.processor.impl.QuestProcessor;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
public class IntegrationTest {

	private IQuestProcessor processor;
	private Map<QuestLocation, Node> expectedPath;
	private QuestArchiver questArchiver;

	@Before
	public void setUp() throws JAXBException, ArchiverException {

		QuestArchive archive = new QuestArchive("src/test/resources/quests");
		questArchiver = new QuestArchiver(archive);
		Quest quest = questArchiver.load("quest1");
		processor = new QuestProcessor(quest, archive);

		expectedPath = new LinkedHashMap<QuestLocation, Node>();
		expectedPath.put(new QuestLocation(1.0,1.0), quest.getNodes().get(1));
		expectedPath.put(new QuestLocation(1.0,1.0), null);
		expectedPath.put(new QuestLocation(3.0,3.0), quest.getNodes().get(3));
	}

	@Test
	public void runQuest() throws ArchiverException {

		for(QuestLocation location : expectedPath.keySet()){

			Node node = processor.processLocation(location);
			assertEquals(expectedPath.get(location), node);
		}

		//questArchiver.saveProgress("quest1", processor.getGame());
	}
}
