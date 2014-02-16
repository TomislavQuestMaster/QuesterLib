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

    public void zip(File file, String filename) throws ArchiverException {

        byte[] buffer = new byte[1024];

        try{

            FileOutputStream outputStream = new FileOutputStream(filename);
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            ZipEntry zipEntry= new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream inputStream = new FileInputStream(file);

            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }

            inputStream.close();
            zipOutputStream.closeEntry();

            zipOutputStream.close();

        }catch(IOException ex){
            throw new ArchiverException("Error zipping file: " + ex.getMessage());
        }
    }
}
