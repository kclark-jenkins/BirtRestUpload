package org.krisbox.birt.examples;

import org.krisbox.birt.examples.utils.impl.RestClientImpl;

import java.io.IOException;

/**
 * Created by kclark on 10/25/16.
 */
public class BirtUploader {
    public BirtUploader(String filename) throws IOException {
        uploadFile(filename);
    }

    private void uploadFile(String filename) {
        try {
            new RestClientImpl().uploadFile(filename);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
