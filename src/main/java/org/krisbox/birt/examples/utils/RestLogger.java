package org.krisbox.birt.examples.utils;

/**
 * Created by kclark on 10/25/16.
 */
public interface RestLogger {
    public void debug(Object message);
    public void info(Object message);
    public void error(Object message);
    public void fatal(Object message);
    public void trace(Object message);
    public void warn(Object message);
}
