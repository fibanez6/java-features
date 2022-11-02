package org.fibanez.newFeature.library.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Java 11 adds the methods Files.readString(Path) and Files.writeString(Path, CharSequence, OpenOption)
 * with various overloads, which make it much easier to read and write files.
 */
public class ReadWriteFile {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URI txtFileUri = ReadWriteFile.class.getClassLoader().getResource("helloworld.txt").toURI();
        String content = Files.readString(Path.of(txtFileUri), Charset.defaultCharset());
        System.out.println("Data: " + content);

        Path tmpFilePath = Path.of(File.createTempFile("tempFile", ".tmp").toURI());
        Path returnedFilePath = Files.writeString(tmpFilePath, "Hello World!", Charset.defaultCharset(), StandardOpenOption.WRITE);
        System.out.println("Written to: " + returnedFilePath);

        System.exit(0);
    }
}
