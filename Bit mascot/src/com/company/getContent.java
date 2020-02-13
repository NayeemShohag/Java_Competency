package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class getContent extends Thread {

    public void run() {
        while(true)
        {
            try {
                Thread.sleep(15000);
                getUrlContents("http://rss.cnn.com/rss/edition.rss");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    private void getUrlContents(String theUrl) {

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            File file = new File("d:\\a.rss");
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(file, true));



            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {

                myWriter.write(line);
                myWriter.newLine();

            }
            // System.out.println(str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            bufferedReader.close();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}


