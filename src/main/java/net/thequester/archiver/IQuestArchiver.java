package net.thequester.archiver;

import net.thequester.model.Quest;

import java.io.File;
import java.util.List;

/**
 * Created by Tomo.
 */
public interface IQuestArchiver {

    Quest load(String questName) throws ArchiverException;

    List<String> fetchAll();
}
