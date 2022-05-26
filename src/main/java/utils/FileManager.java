package utils;

import authors.Author;

import java.util.List;

public class FileManager {
    private FileManager() {
    }

    public static Author getValidAuthor() {
        return FileReader.readObject("src/main/resources/data/Authors/validAuthor.json", Author.class);
    }

}