package org.krisbox.birt.examples.utils.impl;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.krisbox.birt.examples.models.Authentication;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by kclark on 10/25/16.
 */
public class RestClientImpl extends RestPropertiesImpl {
    public RestClientImpl() throws IOException {
        super();

    }
    public boolean uploadFile(String filename) throws IOException {
        debug(super.getUsername());
        Authentication auth = login();
        startUpload(auth, "/Users/kclark/Desktop/test", "testNameOnIhub.txt");
        return false;
    }

    private void startUpload(Authentication auth, String filename, String finalFileName) {
        try {
            HttpClient httpclient;
            HttpPost httppost;
            ArrayList<NameValuePair> postParameters;
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost(super.getUploadURL());


            postParameters = new ArrayList<NameValuePair>();
            debug("++++++" + auth);
            postParameters.add(new BasicNameValuePair("authToken", auth.getAuthToken()));
            postParameters.add(new BasicNameValuePair("id", super.getFolderID()));
            postParameters.add(new BasicNameValuePair("name", finalFileName));
            postParameters.add(new BasicNameValuePair("file", readFile(filename).toString()));

            httppost.setEntity(new UrlEncodedFormEntity(postParameters));

            HttpResponse response = httpclient.execute(httppost);

            InputStream resp = response.getEntity().getContent();

            String body = IOUtils.toString(resp, "UTF-8");
            Gson gson = new GsonBuilder().create();


            debug("+++++++++++" + body);
        }catch(IOException ex){
            fatal(ex);
        }
    }

    private Authentication login() {
        try {
            HttpClient httpclient;
            HttpPost httppost;
            ArrayList<NameValuePair> postParameters;
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost(super.getLoginURL());


            postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("username", super.getUsername()));
            postParameters.add(new BasicNameValuePair("password", super.getPassword()));
            postParameters.add(new BasicNameValuePair("volume",   super.getVolume()));

            httppost.setEntity(new UrlEncodedFormEntity(postParameters));

            HttpResponse response = httpclient.execute(httppost);

            InputStream resp = response.getEntity().getContent();

            String body = IOUtils.toString(resp, "UTF-8");
            Gson gson = new GsonBuilder().create();
            Authentication auth = gson.fromJson(body, Authentication.class);

            debug(body);
            return auth;
        }catch(IOException ex){
            fatal(ex);
        }

        return null;
    }

    private byte[] readFile(String filename) {
        try {
            Path path = Paths.get(filename);
            byte[] data = Files.readAllBytes(path);
            return data;
        }catch(IOException ex){
            fatal(ex);
        }

        return null;
    }
}
