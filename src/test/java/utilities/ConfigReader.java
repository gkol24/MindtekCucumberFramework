package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;

public class ConfigReader {

    private static FileInputStream input;
    private static Properties properties;

    static {
        String path=System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";

        try{
            input= new FileInputStream(path);
            properties= new Properties();
            properties.load(input);
        }catch (FileSystemNotFoundException e) {
            System.out.println("Path for properties file is invalid");
        }catch (IOException e){
            System.out.println("Failed to load the properties file");
        }finally {
            try {
                assert input !=null;
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occurred while closing input object");
            }

        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);

    }
}
