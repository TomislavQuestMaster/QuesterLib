package net.thequester.archiver;

import net.thequester.model.Quest;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Tomo.
 */
public class ArchiverTest {

    private QuestArchiver questArchiver;

    @Test
    public void test() throws ArchiverException {

        questArchiver = new QuestArchiver();

        questArchiver.loadAll("src/test/resources/quests");

        List<Quest> quests = questArchiver.getQuests();

        assertEquals(quests.size(),1);
    }

}
