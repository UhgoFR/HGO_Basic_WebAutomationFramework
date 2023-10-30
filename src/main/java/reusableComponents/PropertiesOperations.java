package reusableComponents;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {
    static Properties prop = new Properties();
    public static String getPropertyValueByKey(String key) throws Exception {
        //Load data from properties file
        String propertiesFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
        FileInputStream fis = new FileInputStream(propertiesFilePath);
        prop.load(fis);

        //Read data
        String value = prop.get(key).toString();
        if (StringUtils.isEmpty(value)){
            throw new Exception("Value is not specified for key: "+ key +" in properties file");
        }
        return value;
    }
}
