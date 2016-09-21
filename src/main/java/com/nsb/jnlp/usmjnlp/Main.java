package com.nsb.jnlp.usmjnlp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");
        String color="red";
        if(args.length>0){
            color=args[0];
        }
        String[] cmd = new String[]{"sh", "-c", "xlogo -fg "+color};

        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
            System.out.println("Finished");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.println("End");
    }
}
