package org.krisbox.birt.examples;

import org.krisbox.birt.examples.utils.impl.RestLoggerImpl;

import java.io.IOException;

/**
 * Created by kclark on 10/25/16.
 */
public class Tests extends RestLoggerImpl {
    public Tests() {
        super();
        debug("Tests()");
        testUpload();
    }

    private void testUpload() {
        try {
            new BirtUploader("stuff");
        }catch(IOException ex){
            error(ex);
        }
    }

    public static void main(String[] args) {
        new Tests();
    }
}
