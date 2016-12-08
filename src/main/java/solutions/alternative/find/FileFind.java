package solutions.alternative.find;

import java.io.File;

public class FileFind {

    public void find(String sourceDirectoryName, String filename) {
        File sourceDirectory = new File(sourceDirectoryName);

        if (!validDirectoryName(sourceDirectory)) {
            return;
        }

    }

    private boolean validDirectoryName(File sourceDirectory) {
        if (!sourceDirectory.exists()) {
            System.out.println(String.format(
                    "Error! Directory %s does not exists",
                    sourceDirectory.getName())
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
