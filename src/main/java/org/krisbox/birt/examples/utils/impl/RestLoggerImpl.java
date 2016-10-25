package org.krisbox.birt.examples.utils.impl;

import org.apache.log4j.Logger;
import org.krisbox.birt.examples.utils.RestLogger;

/**
 * Created by kclark on 10/25/16.
 */
public class RestLoggerImpl {
    private final Logger LOGGER;

    public RestLoggerImpl() {
        LOGGER = Logger.getLogger(RestLoggerImpl.class);
    }

    public void debug(Object message){LOGGER.debug(message);}
    public void info(Object message){LOGGER.info(message);}
    public void error(Object message){LOGGER.error(message);}
    public void fatal(Object message){LOGGER.fatal(message);}
    public void trace(Object message){LOGGER.trace(message);}
    public void warn(Object message){LOGGER.warn(message);}
}
