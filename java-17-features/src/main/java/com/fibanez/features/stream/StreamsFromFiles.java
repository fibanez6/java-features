package com.fibanez.features.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * There are many methods in the classes of the java.io and java.nio.file packages to support I/O operations using streams. For example:
 * You can read text from a file as a stream of strings in which each element represents one line of text from the file.
 * <p>
 * You can obtain a stream of JarEntry from a JarFile.
 * You can obtain the list of entries in a directory as a stream of Path.
 * You can obtain a stream of Path that is a result of a file search in a specified directory.
 * You can obtain a stream of Path that contains the file tree of a specified directory.
 */
public class StreamsFromFiles {

    public static void main(String[] args) {
        // Read the contents of the file luci1.txt
        readFileContents("luci1.txt");
        // Print the file tree for the current working
        // directory
        listFileTree();
    }

    public static void readFileContents(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("The file "
                    + path.toAbsolutePath()
                    + " does not exist.");
            return;
        }
        try (Stream<String> lines = Files.lines(path)) {
            // Read and print all lines
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFileTree() {
        Path dir = Paths.get("");
        System.out.printf("%nThe file tree for %s%n",
                dir.toAbsolutePath());
        try (Stream<Path> fileTree = Files.walk(dir)) {
            fileTree.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
