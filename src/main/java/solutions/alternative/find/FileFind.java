package solutions.alternative.find;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileFind {

    public void find(String sourceDirectoryName, String fileName) {
        File sourceDirectory = new File(sourceDirectoryName);

        if (!validDirectoryName(sourceDirectory)) {
            return;
        }

        findFileInDirectory(sourceDirectory, fileName);
    }

    private void findFileInDirectory(File directory, String fileName) {
        File[] directoryContent = directory.listFiles();

        if (directoryContent == null) {
            return;
        }

        List<File> subDirectories = Arrays.stream(directoryContent)
                .filter(File::isDirectory)
                .collect(Collectors.toList());

        List<File> directoryFiles = Arrays.stream(directoryContent)
                .filter(File::isFile)
                .collect(Collectors.toList());

    }

    private boolean validDirectoryName(File sourceDirectory) {
        if (!sourceDirectory.exists()) {
            System.out.println(String.format(
                    "Error! Directory %s does not exists",
                    sourceDirectory.getPath())
            );

            return false;
        }

        if (!sourceDirectory.isDirectory()) {
            System.out.println(String.format(
                    "Error! Object at %s is not a directory",
                    sourceDirectory.getPath())
            );

            return false;
        }

        return true;
    }

}
