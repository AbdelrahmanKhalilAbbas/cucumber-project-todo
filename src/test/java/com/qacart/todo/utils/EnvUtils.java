package com.qacart.todo.utils;

import java.io.IOException;
import java.util.Properties;

public class EnvUtils {
    private Properties prop;
    public static EnvUtils envUtils;
    private EnvUtils() throws IOException {
        String env = System.getProperty("env","PRODUCTION");
        switch (env){
            case "PRODUCTION" ->{
                prop = ConfigUtil.readConfig("src/test/resources/properties/production.properties");
            }
            case "STAGING" ->{
                prop = ConfigUtil.readConfig("src/test/resources/properties/Staging.properties");
            }
            case "LOCAL" ->{
                prop = ConfigUtil.readConfig("src/test/resources/properties/local.properties");
            }
            default -> {
                throw new RuntimeException("Environment not supported");
            }
        }
    }
    public static EnvUtils getInstance() throws IOException {
        envUtils = new EnvUtils();
        return envUtils;
    }
    public String getURL(){
        return prop.get("URL").toString();
    }
    public String getEmail(){
        return prop.get("EMAIL").toString();
    }
    public String getPassword(){
        return prop.get("PASSWORD").toString();
    }
}
