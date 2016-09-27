package com.nsb.jnlp.makejnlp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MakeJnlp extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jar_path=request.getParameter("JNLP_JAR_PATH");

        String ne_release=request.getParameter("NE_RELEASE");
        String ne_type=request.getParameter("NE_TYPE");
        //String emlim_ip = request.getParameter("EMLIM_IP");
        //String emlim_port = request.getParameter("EMLIM_PORT");
        String group_id = request.getParameter("GROUP_ID");
        String ne_id = request.getParameter("NE_ID");
        String nameServerFile_url=request.getParameter("NAMESERVERFILE_URL");



        /*String emlim_ip="172.24.168.153";
        String emlim_port="5028";
        String group_id="100";
        String ne_id="1";
        String jar_path="q3neusm";
        String jar_name="q3neusm.jar";*/

        String protocol = request.getScheme();
        String ip = request.getServerName();
        int port = request.getServerPort();
        //String app = request.getContextPath();


        //String codebase=protocol + "://" + ip + ":" + port + "/" + jar_path;
        //String jnlp_href=protocol + "://" + ip + ":" + port + app+"/makejnlp?EMLIM_IP="+emlim_ip+"&amp;EMLIM_PORT="+emlim_port+"&amp;GROUP_ID="+group_id+"&amp;NE_ID="+ne_id+"&amp;JAR_PATH="+jar_path+"&amp;JAR_NAME="+jar_name+"&amp;BAT_NAME="+bat_name;
        response.setContentType("application/x-java-jnlp-file");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        //out.println("<jnlp spec=\"1.0+\" codebase=\"" + codebase +"\">");
        out.println("<jnlp spec=\"1.0+\">");
        //out.println("<jnlp spec=\"1.0+\" codebase=\"" + codebase + "\" href=\""+jnlp_href+"\">");

        out.println("<information>");
        out.println("  <title>q3neusm</title>");
        out.println("  <vendor>nsb</vendor>");
        out.println("  <homepage href=\"\"/>");
        out.println("  <description>q3 ne usm</description>");
        //out.println("  <description kind=\"short\">Web Start Version</description>");
        out.println("</information>");
        out.println("<security>");
        out.println("  <all-permissions/>");
        out.println("</security>");
        out.println("<resources>");
        out.println("  <j2se version=\"1.6+\"/>");
        out.println("  <jar href=\""+jar_path+"\" main=\"true\"/>");
        out.println("</resources>");

        out.println("<application-desc main-class=\"com.nsb.jnlp.usmjnlp.Main\">");
        out.println("<argument>"+ ne_type +"</argument>");
        out.println("<argument>"+ ne_release +"</argument>");
        //out.println("<argument>"+ emlim_ip +"</argument>");
        //out.println("<argument>"+ emlim_port +"</argument>");
        out.println("<argument>"+ group_id +"</argument>");
        out.println("<argument>"+ ne_id +"</argument>");
        out.println("<argument>"+ nameServerFile_url +"</argument>");
        out.println("</application-desc>");

        out.println("</jnlp>");
        out.flush();
        out.close();

    }
}
