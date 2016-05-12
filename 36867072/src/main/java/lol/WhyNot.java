package lol;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class WhyNot {

    public Object fileCreationTime(File file) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            System.out.println("LOL " + attributes);
            if (attributes == null) {
                throw new RuntimeException("lol");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object();
    }
}