package net.thequester.archiver;

import org.junit.Test;

import java.io.File;

/**
 * Created by Tomo.
 */
public class ZipManagerTest {

    @Test
    public void test(){
        ZipManager zipManager = new ZipManager();

        File questFile = new File("src/test/resources/node.xml");
        String outputName = "src/test/resources/node.zip";

        zipManager.zip(questFile, outputName);

    }
}
