package net.thequester.model;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
public class ModelTest {

    @Test
    public void nodeIsDeSerializedCorrectly() throws JAXBException {

        JAXBContext jaxbContextMessage = JAXBContext.newInstance(Node.class);
        Unmarshaller unmarshaller = jaxbContextMessage.createUnmarshaller();

        File file = new File(Paths.get("src/test/resources/node.xml").toUri());

        Node node = (Node)unmarshaller.unmarshal(file);

        assertEquals(node.getId(),Integer.valueOf(1));

    }

    @Test
    public void questIsDeSerializedCorrectly() throws JAXBException {

        JAXBContext jaxbContextMessage = JAXBContext.newInstance(Quest.class);
        Unmarshaller unmarshaller = jaxbContextMessage.createUnmarshaller();

        File file = new File(Paths.get("src/test/resources/quest.xml").toUri());

        Quest quest = (Quest)unmarshaller.unmarshal(file);

        assertEquals(2,quest.getNodes().size());

    }

}
