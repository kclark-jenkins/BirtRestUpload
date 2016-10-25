package org.krisbox.birt.examples.utils.impl;

import org.krisbox.birt.examples.utils.RestLogger;
import org.krisbox.birt.examples.utils.RestProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kclark on 10/25/16.
 */
public class RestPropertiesImpl extends RestLoggerImpl implements RestProperties {
    private final String PROPS_FILENAME = "src/main/resources/rest.properties";

    private Properties prop = new Properties();

    public RestPropertiesImpl() throws FileNotFoundException, IOException {
        super();
        debug("PingPropertiesImpl()");
        readProperties();
    }

    public String getUsername() {
        return prop.get("USERNAME").toString();
    }

    public String getPassword() {
        return prop.get("PASSWORD").toString();
    }

    public String getVolume() {
        return prop.get("VOLUME").toString();
    }

    public String getActURL() {
        return prop.get("ACTURL").toString();
    }

    public String getLoginURL() { return prop.get("ACTURL").toString() + prop.getProperty("LOGIN");}

    public String getFolderID() { return prop.get("FOLDERID").toString();}

    public String getUploadURL() { return prop.get("ACTURL").toString() + prop.getProperty("UPLOAD");}

    private void readProperties() throws FileNotFoundException, IOException {
        debug("PingPropertiesImpl.readProperties()");
        prop.load(new FileInputStream(PROPS_FILENAME));
    }
}
