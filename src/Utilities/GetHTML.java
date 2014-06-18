package Utilities;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class GetHTML{
	static public String getHTMLcontent (String urlstring) throws Exception {
        StringBuffer sb = new StringBuffer();
        String temp = "";
        URL url = new URL(urlstring);
        //System.out.println(url);
        //HttpConnection conn = null;
	    URLConnection myurlcon = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(myurlcon.getInputStream())); 
        while ((temp = in.readLine()) != null) {
            sb.append(temp + " ");
        }
        in.close();
        return sb.toString();
	}
	

    public static String getNewHtml(String htmlurl, int page) throws IOException{
    	 StringBuffer resulturl = new StringBuffer();
          
        URL url=new URL(htmlurl);   
        URLConnection conn=url.openConnection();   
      conn.setDoOutput(true);   
       OutputStreamWriter out=new OutputStreamWriter(conn.getOutputStream());   
     
       String str = "page=" + page;//= "query=cardiovascular";   
      
        out.write(str);   
       out.flush();   
        out.close();   

        BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));   
        String line= "";   
 
        while((line=reader.readLine())!=null)   
    {   
        	 resulturl.append(line + " ");
             //System.out.println(resulturl);
     } 
        reader.close();
        return resulturl.toString();
    }

    public static ArrayList<String> getURL(String s) {
        String regex;
        ArrayList<String> list = new ArrayList<String>();
        regex = "<td valign=\"top\" scope=\"row\"><a href=\".*?\">";
        Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(s);
        int count = 0;
        while (ma.find()) {
        	String url = ma.group();
        	if(count%2==0){
            list.add("http://www.sec.gov" + url.substring(38, url.length() -2));
        	}
        	count++;
        }
        return list;
        //return outTag(title);
    }
    
    public static ArrayList<String> getName(String s) {
        String title = "";
        ArrayList<String> list = new ArrayList<String>();
        String regex = "<td scope=\"row\">.*?<br />";
        Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
        	title = ma.group();
            list.add(title.substring(16, title.length() - 6));
        }
        return list;
        //return outTag(title);
    }
    
    public static String getDocument(String s) {
        String link = "";
        String regex = "<td nowrap=\"nowrap\"><a href=\".*?\" id=\"documentsbutton\"";
        Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
        	link = ma.group();
            link =  "http://www.sec.gov" + link.substring(link.indexOf("href") + 6, link.indexOf("documentsbutton") - 6);
            if(!link.equals(""))
            	break;
        }
            return link;
        //return outTag(title);
    }

    public static String getAddress(String s) {
        String addressall = "";
        String regex = "<div class=\"mailer\">Business Address.*?</div>";
        Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        Matcher ma = pa.matcher(s);
        while (ma.find()) {
        	addressall = ma.group();
            addressall = addressall.substring(addressall.indexOf("Address") + 7, addressall.indexOf("</div>") - 1);
            addressall = addressall.replaceAll("<span class=\"mailerAddress\">", "");
            addressall = addressall.replaceAll("</span>", "||");
            addressall = addressall.replaceAll("  ", "");
            addressall = addressall.replaceAll("    ", "");
            addressall = addressall.replaceAll("\t", "");
        }
        return addressall;
        //return outTag(title);
    }
    public static String outTag(String s) {
        return s.replaceAll("<.*?>", "   ");
    }


}
