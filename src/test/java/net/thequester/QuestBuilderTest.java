package net.thequester;

import net.thequester.model.Event;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomo.
 */
public class QuestBuilderTest {

    @Test
    public void test() throws JAXBException {

        Event event = new Event();
        Map<Integer, Integer> causes = new HashMap<Integer, Integer>();
        causes.put(0, 2);
        causes.put(1, 1);
        event.setCauses(causes);

        Quest quest = (new QuestBuilder()).node(1.0, 1.0)
                                          .node(2.0, 2.0)
                                          .node(3.0, 3.0)
                                          .event(2, event).build();

        JAXBContext jaxbContextMessage = JAXBContext.newInstance(Quest.class);
        Marshaller marshaller = jaxbContextMessage.createMarshaller();
        File file = new File(Paths.get("src/test/resources/quest.xml").toUri());

        marshaller.marshal(quest, file);
    }

}
