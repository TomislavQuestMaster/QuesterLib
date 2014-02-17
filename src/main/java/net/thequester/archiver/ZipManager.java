package net.thequester.archiver;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Tomo.
 */
public class ZipManager {

	public void zip(String fileName, String zipName) throws ArchiverException {

		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(zipName);
		} catch (FileNotFoundException e) {
			throw new ArchiverException("Creation of outputStream failed: " + e.getMessage());
		}
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

		File file = new File(fileName);

		try {
            /*
			if (file.isDirectory()) {
				zipDirectory(file, zipOutputStream);
				return;
			}
            */
			zipFile(file, zipOutputStream);
            zipOutputStream.close();

		} catch (IOException e) {
			throw new ArchiverException("Zipping failed: " + e.getMessage());
		}

	}

	private void zipDirectory(File directory, ZipOutputStream outputStream) throws IOException {

		for (File file : directory.listFiles()) {
			zipFile(file, outputStream);
		}
	}

	private void zipFile(File file, ZipOutputStream outputStream) throws IOException {

		byte[] buffer = new byte[1024];

		ZipEntry zipEntry = new ZipEntry(file.getName());
		outputStream.putNextEntry(zipEntry);

		FileInputStream inputStream = new FileInputStream(file);

		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}

		inputStream.close();
		outputStream.closeEntry();
	}

	public void delete(File file) throws ArchiverException {

		if (!file.delete()) {
			throw new ArchiverException("Deleting of file failed");
		}
	}

    public File unzip(File zippedFile) throws ArchiverException {

        try {
            FileInputStream inputStream = new FileInputStream(zippedFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputStream));
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {

                int size;
                byte[] buffer = new byte[2048];

                FileOutputStream outputStream = new FileOutputStream(entry.getName());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, buffer.length);

                while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
                    bufferedOutputStream.write(buffer, 0, size);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }

            zis.close();
            inputStream.close();
        } catch (IOException e) {
            throw new ArchiverException("Unzipping failed: " + e.getMessage());
        }

        return null;
    }


}
