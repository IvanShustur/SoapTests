package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private FileReader() {
}

    public static <T> T readObject(String filePath, Class<T> tClass) {
        T t = null;
        try {
            t = new ObjectMapper().readValue(new File(filePath), tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> List<T> readListOfObject(String filePath, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
            list = mapper.readValue(new File(filePath), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}