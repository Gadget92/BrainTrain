package solutions.alternative.find;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileFind {
    private List<String> foundFiles = new ArrayList<>();

    public void find(String sourceDirectoryName, String fileName) {
        File sourceDirectory = new File(sourceDirectoryName);

        if (!validDirectoryName(sourceDirectory)) {
            return;
        }

        findFileInDirectory(sourceDirectory, fileName);

        if (foundFiles.isEmpty()) {
            System.out.println(
                    String.format(
                            "Could not find %s in directory %s",
                            fileName,
                            sourceDirectory));
        } else {
            System.out.println("Found files:");
            foundFiles.forEach(System.out::println);
        }
    }

    private void findFileInDirectory(File directory, String fileName) {
        File[] directoryEntries = directory.listFiles();

        if (directoryEntries == null) {
            return;
        }

        List<File> directoryContent = Arrays.asList(directoryEntries);


        List<String> foundFilesList = directoryContent.parallelStream()
                .filter(File::isFile)
                .filter(directoryFile -> directoryFile.getName().toLowerCase().contains(fileName))
                .map(File::getPath)
                .collect(Collectors.toCollection(ArrayList::new));

        foundFiles.addAll(foundFilesList);

        directoryContent.parallelStream()
                .filter(File::isDirectory)
                .forEach(subDirectory -> findFileInDirectory(subDirectory, fileName));

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
