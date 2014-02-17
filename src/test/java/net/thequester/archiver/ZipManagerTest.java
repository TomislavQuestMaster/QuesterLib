package net.thequester.archiver;

import org.junit.Test;

import java.io.File;

/**
 * Created by Tomo.
 */
public class ZipManagerTest {

    @Test
    public void zippingFile() throws ArchiverException {
        ZipManager zipManager = new ZipManager();

        String questFile = "src/test/resources/node.xml";
        String outputName = "src/test/resources/node.zip";

        zipManager.zip(questFile, outputName);

    }

    @Test
    public void zippingDirectory() throws ArchiverException {
        ZipManager zipManager = new ZipManager();

        String questFile = "src/test/resources/quests";
        String outputName = "src/test/resources/quest.zip";

        zipManager.zip(questFile, outputName);

    }


    @Test
    public void deleteTest() throws ArchiverException {
        ZipManager zipManager = new ZipManager();

        File questFile = new File("src/test/resources/quest.zip");

        zipManager.delete(questFile);

    }


    @Test
    public void unzippingDirectory() throws ArchiverException {
        ZipManager zipManager = new ZipManager();

        File file = new File("src/test/resources/quests/quest3.zip");

        zipManager.unzip(file);

    }
}
