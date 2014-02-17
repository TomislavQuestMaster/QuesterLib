package net.thequester.archiver;

import net.thequester.model.Quest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomo.
 */
public class QuestArchiver implements IQuestArchiver {

    private List<Quest> quests;

    public QuestArchiver() {
        quests = new ArrayList<Quest>();
    }

    public void loadAll(String directoryLocation) throws ArchiverException {

        File directory = new File(directoryLocation);

        for (File questFile : directory.listFiles()) {
            quests.add(load(questFile));
        }
    }


    @Override
    public Quest load(File file) throws ArchiverException {

        try {

            JAXBContext context = JAXBContext.newInstance(Quest.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //File file = new File(Paths.get(fileName).toUri());
            return (Quest)unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new ArchiverException("Failed to load quest: " + e.getMessage());
        }

    }

    public List<Quest> getQuests() {
        return quests;
    }
}
