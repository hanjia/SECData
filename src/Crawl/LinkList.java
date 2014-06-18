package Crawl;

import java.util.ArrayList;

public class LinkList {
	String sic = "";

       public String getLink(String sic){
            this.sic = sic;
            String link = "http://www.sec.gov/cgi-bin/browse-edgar?company=&match=&CIK=&filenum=&State=CA&Country=&SIC=" +sic + "&owner=exclude&Find=Find+Companies&action=getcompany";
    	   return link;
       }
       
       public String getNewLink(String sic){
           this.sic = sic;
           String link = "http://www.sec.gov/cgi-bin/browse-edgar?action=getcompany&amp;SIC="+ sic +"&amp;State=CA&amp;owner=exclude&amp;match=&amp;start=40&amp;count=40&amp;hidefilings=0";
   	   return link;
      }
}
