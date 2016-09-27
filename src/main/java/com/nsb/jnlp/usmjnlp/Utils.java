package com.nsb.jnlp.usmjnlp;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by junyuel on 9/26/2016.
 */
public class Utils {
    static private final int BUFFER_SIZE=8096;

    public static void saveToFile(String destUrl, String filename) throws IOException{
        FileOutputStream fos=null;
        BufferedInputStream bis=null;
        HttpURLConnection httpUrl=null;
        URL url=null;
        byte[] buf=new byte[BUFFER_SIZE];
        int size=0;

        url=new URL(destUrl);
        httpUrl=(HttpURLConnection)url.openConnection();
        httpUrl.connect();
        bis=new BufferedInputStream(httpUrl.getInputStream());
        fos=new FileOutputStream(filename);
        System.out.println(destUrl+" TO "+filename);
        while(-1!=(size=bis.read(buf))){
            fos.write(buf, 0, size);
        }
        fos.close();
        bis.close();
        httpUrl.disconnect();
    }

    public static String getBatName(String ne_type, String ne_release) throws Exception{
        if(new String("ne1662smc 2.7B").compareToIgnoreCase(ne_type+" "+ne_release)>=0){
            return "run_usm_q3v5.bat";
        }else{
            throw new Exception("getBatName");
        }
    }
}
