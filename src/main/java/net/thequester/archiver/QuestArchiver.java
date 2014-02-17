package net.thequester.archiver;

import net.thequester.model.Quest;
import net.thequester.model.QuestArchive;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomo.
 */
public class QuestArchiver implements IQuestArchiver {

	private QuestArchive archive;

	public QuestArchiver(QuestArchive archive) {

		this.archive = archive;
	}

	@Override
	public List<String> fetchAll() {

		List<String> result = new ArrayList<String>();

		File directory = new File(archive.getLocation());

		for (File questFile : directory.listFiles()) {
			result.add(questFile.getName());
		}

		return result;
	}

	@Override
	public Quest load(String questName) throws ArchiverException {

		File questArchive = new File(archive.getLocation() + "/" + questName);
		if (!questArchive.isDirectory()) {
			throw new ArchiverException("Not a valid quest archive");
		}

        for(File archiveElement : questArchive.listFiles()){
            if(archiveElement.getName().equals("quest.xml")){
                return getQuestFromArchive(archiveElement);
            }
        }

        throw new ArchiverException("No quest descriptor in archive");
    }

    private Quest getQuestFromArchive(File file) throws ArchiverException {

        try {
            JAXBContext context = JAXBContext.newInstance(Quest.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Quest) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new ArchiverException("Failed to load quest: " + e.getMessage());
        }
    }

    public void addNewArchive(File zippedQuest) throws ArchiverException {

        ZipManager zipManager = new ZipManager();

        File questDir = zipManager.unzip(zippedQuest);
        zipManager.delete(zippedQuest);

        archive.getQuests().add(load(questDir.getName()));
    }
}
