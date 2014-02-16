package net.thequester.archiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Tomo.
 */
public class ZipManager {

    public void zip(File file, String filename){

        byte[] buffer = new byte[1024];

        try{

            FileOutputStream outputStream = new FileOutputStream(filename);
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            ZipEntry zipEntry= new ZipEntry("node.xml");
            zipOutputStream.putNextEntry(zipEntry);
            FileInputStream in = new FileInputStream(file);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }

            in.close();
            zipOutputStream.closeEntry();

            //remember close it
            zipOutputStream.close();

            System.out.println("Done");

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
