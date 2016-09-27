package com.nsb.jnlp.usmjnlp;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        if(args.length<5){
            System.out.println("Param error!");
            return;
        }
        System.out.println(args[0]+" "+args[1]+" "+args[2]+" "+args[3]+" "+args[4]);
        String ne_type=args[0];
        String ne_release=args[1];
        //String emlim_ip = args[2];
        //String emlim_port = args[3];
        String group_id = args[2];
        String ne_id = args[3];
        String nameServerFile_url=args[4];
        String bat_name=null;
        try {
            bat_name=Utils.getBatName(ne_type, ne_release);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Get bat_name failed!");
            return;
        }


        String usm_root=System.getenv("OMSN_NE_USM_ROOT");
        System.out.println("OMSN_NE_USM_ROOT:"+usm_root);
        try {
            Utils.saveToFile(nameServerFile_url, usm_root+"conf\\NameServerFile.nr6");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("saveToFile failed");
            return;
        }

        System.out.println(bat_name+" "+group_id+" "+ne_id);
        String[] cmd = new String[]{bat_name, group_id, ne_id};
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
