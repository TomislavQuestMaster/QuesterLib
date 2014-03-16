package net.thequester.processor;

import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.processor.impl.QuestProcessor;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
@Ignore
public class QuestProcessorTest {

    QuestProcessor questProcessor;
	Quest quest;

    @Before
    public void setUp() throws JAXBException {
		JAXBContext jaxbContextMessage = JAXBContext.newInstance(Quest.class);
		Unmarshaller unmarshaller = jaxbContextMessage.createUnmarshaller();
		File file = new File(Paths.get("src/test/resources/quests/quest1/quest.xml").toUri());
		quest = (Quest)unmarshaller.unmarshal(file);

        questProcessor = new QuestProcessor(quest);
    }

    @Test
    public void test(){

		Node node = new Node();
		node.setId(0);

        List<Node> children = questProcessor.getChildren(node);

		assertEquals(2, children.size());
    }




}
