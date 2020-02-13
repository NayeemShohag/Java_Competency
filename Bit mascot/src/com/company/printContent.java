package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class printContent extends Thread {
    public void run() {

       while (true)
       {

           try {
               Thread.sleep(20000);
               pullLinks();

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }

    private void pullLinks()
    {
        BufferedReader bufferedReader;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("d:\\a.rss")));
            while ((line= bufferedReader.readLine())!=null)
            {
                String regex = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg)";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                int i=0;
                while(m.find()) {
                    String urlStr = m.group();

                    System.out.println(urlStr);
                    i++;
                }
                System.out.println(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
