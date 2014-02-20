package net.thequester.processor;

import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tdubravcevic
 */
public class QuestProcessorTest {

    QuestProcessor questProcessor;

    @Before
    public void setUp(){
        Quest quest = new Quest();
        questProcessor = new QuestProcessor(quest);
    }

    @Ignore
    @Test
    public void test(){

        Game game = new Game();


        Node node = questProcessor.gotoNext(game);

        assertEquals(node.getId(), Integer.valueOf(2));
    }

}
