package lol;

import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("LOL");
        Properties p = new Properties();
        p.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        System.out.println(String.format("Profile: %s", p.getProperty("profile")));
    }
}