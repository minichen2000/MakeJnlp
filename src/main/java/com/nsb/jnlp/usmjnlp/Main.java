package com.nsb.jnlp.usmjnlp;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        if(args.length<5){
            System.out.println("Param error!");
            return;
        }

        String[] cmd = new String[]{args[0], args[1], args[2], args[3], args[4]};
        System.out.println(args[0]+" "+args[1]+" "+args[2]+" "+args[3]+" "+args[4]);


        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
            //System.out.println("Finished");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch(Exception e){
            System.out.println(e.toString());
        }
        //System.out.println("End");
    }
}
