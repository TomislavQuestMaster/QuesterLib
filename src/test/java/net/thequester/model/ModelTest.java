package net.thequester.model;

import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
@Ignore
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

        assertEquals(1, quest.getNodes().size());

        assertEquals(quest.getConnections().get(1).getChildren().get(0),Integer.valueOf(2));

    }

    @Test
    public void questIsSerializedCorrectly() throws JAXBException {

        JAXBContext jaxbContextMessage = JAXBContext.newInstance(Quest.class);
        Marshaller marshaller = jaxbContextMessage.createMarshaller();

        File file = new File(Paths.get("src/test/resources/quest.xml").toUri());

        Node node = new Node();
        node.setId(1);
        node.setQuestLocation(new QuestLocation(0.0,0.0));

        Map<Integer,Connection> map = new HashMap<Integer, Connection>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        Connection connection = new Connection();
        connection.setChildren(list);
        connection.setParents(list);
        map.put(1, connection);

        Quest quest= new Quest();

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(node);

        quest.setNodes(nodes);
        quest.setConnections(map);


        marshaller.marshal(quest,file);

        //nodeIsDeSerializedCorrectly();

    }

}
