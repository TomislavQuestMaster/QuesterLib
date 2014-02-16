package net.thequester.archiver;

import net.thequester.model.Quest;

import java.io.File;

/**
 * Created by Tomo.
 */
public interface IQuestArchiver {

    Quest load(File file) throws ArchiverException;
}
