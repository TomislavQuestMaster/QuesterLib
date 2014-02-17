package net.thequester.archiver;

import net.thequester.model.Quest;
import net.thequester.model.QuestArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tomo.
 */
public class QuestArchiverTest {

    private QuestArchiver questArchiver;

    @Before
    public void setUp(){
        questArchiver = new QuestArchiver(new QuestArchive("src/test/resources/quests"));
    }

    @Test
     public void fetchingSuccessful() throws ArchiverException {

        List<String> quests = questArchiver.fetchAll();

        assertEquals(quests.size(),2);
        assertTrue(quests.contains("quest1"));
        assertTrue(quests.contains("quest2"));
    }

    @Test
    public void loadingSuccessful() throws ArchiverException {

        Quest quest = questArchiver.load("quest1");

        Assert.assertEquals(quest.getNodes().size(),1);
    }

}
