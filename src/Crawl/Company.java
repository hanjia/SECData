package Crawl;

import Utilities.GetHTML;

public class Company {
public String companyname;
public String companyurl;
public String address2012;
public String address2010;
public String address2007;
public String address2004;
public String address2001;
public String address1998;
public String address1995;

public void setAddress() throws Exception{
	String link2010 = this.companyurl + "&dateb=20101231";
	String link2007 = this.companyurl + "&dateb=20071231";
	String link2004 = this.companyurl + "&dateb=20041231";
	String link2001 = this.companyurl + "&dateb=20011231";
	String link1998 = this.companyurl + "&dateb=19981231";
	String link1995 = this.companyurl + "&dateb=19951231";
	String newcontent;
	
	String content = GetHTML.getHTMLcontent(this.companyurl);
	String docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address2012 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link2010);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address2010 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link2007);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address2007 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link2004);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address2004 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link2001);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address2001 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link1998);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address1998 = GetHTML.getAddress(newcontent);
	}
	
	content = GetHTML.getHTMLcontent(link1995);
	docurl = GetHTML.getDocument(content);
	if(!docurl.equals("")){
	newcontent = GetHTML.getHTMLcontent(docurl);
	this.address1995 = GetHTML.getAddress(newcontent);
	}
	
	content = null;
	newcontent = null;
	
}


public String getAddress(int year){
	 String address = "";
	   switch (year) {
       case 2012:  address = address2012;
                break;
       case 2010:  address = address2010;
                break;
       case 2007:  address = address2007;
                break;
       case 2004:  address = address2004;
                break;
       case 2001:  address = address2001;
                break;
       case 1998:  address = address1998;
                break;
       case 1995:  address = address1995;
                break;

   }
	   return address;
}
}
