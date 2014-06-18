package Crawl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import Utilities.GetHTML;


public class ExtractData {
	public static void main(String[] args) throws Exception {
		Hashtable<String, Company> companytable = new Hashtable<String, Company>();
		String[] codelist = {"3570","3571","3572","3575","3576","3577","5045","5734","7370","7371","7372","7373","7374"};
		
		for(String code : codelist){
		String siccode = code;
        LinkList ll = new LinkList();
        String link = "";
        ArrayList<String> htmllist = new ArrayList<String>();
        ArrayList<String> namelist = new ArrayList<String>();

		link = ll.getLink(siccode); //All links in the category pages (120,21,34,1)
		//System.out.println(link);
		String content = GetHTML.getHTMLcontent(link);
		//System.out.println(content);
		htmllist = GetHTML.getURL(content);
		namelist = GetHTML.getName(content);
		
		if(content.contains("Next 40")){
			String newlink = ll.getNewLink(siccode);
			String newcontent = GetHTML.getHTMLcontent(newlink);
			htmllist.addAll(GetHTML.getURL(newcontent));
			namelist.addAll(GetHTML.getName(newcontent));
		}
		
		for(int i = 0 ; i < htmllist.size(); i++){
		System.out.println(namelist.get(i) + "\t"+ htmllist.get(i));
		Company com = new Company();
		com.companyname = namelist.get(i);
		com.companyurl = htmllist.get(i);
		com.setAddress();
		System.out.println(com.address2010);
		companytable.put(namelist.get(i), com);
		}		
		}
		System.out.println(companytable.size());
		Enumeration em = companytable.keys();
		while (em.hasMoreElements()) {
			String name = (String) em.nextElement();
			Company c = companytable.get(name);
			System.out.println(name + "\t" + c.getAddress(2012) + "\t" + c.getAddress(2010) + "\t" + c.getAddress(2007) + "\t" + c.getAddress(2004) + "\t" + c.getAddress(2001) + "\t" + c.getAddress(1998) + "\t" + c.getAddress(1995));
		}
		
        /**
		for(int num = 0; num < htmllist.size();num++){
		urls = GetHTML.getURL(htmllist.get(num));// Grab all links

		for(int i = 0; i < urls.size();i++){
			int indexstart = 0;
			int indexend = 0;
			if(urls.get(i).contains("javascript:openWindow")){
				indexstart = urls.get(i).indexOf("('");
				indexend = urls.get(i).indexOf("',");
				indexstart = indexstart + 2;
			    String useful = urls.get(i).substring(indexstart, indexend);	  
			    resulturls.add(useful);
			    //System.out.println(useful);
		     }
		}//To get all detailed result links

		}
		
		//for(int i =0;i <resulturls.size();i++){
			//  Insert.insertURL(i, resulturls.get(i));
//		}
	
		//System.out.println(resulturls.size());
		
		//System.out.println(resulturls.size());

		for(int j = 0 ; j< resulturls.size();j++) {
		String htmlresult1 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=general");
		String htmlresult2 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=reference");
		String htmlresult3 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=Genome");
		String htmlresult4 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=Proteome");
		String htmlresult5 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=Glycome");
		String htmlresult6 = GetHTML.getHTMLcontent(resulturls.get(j)+ "&pageType=Biology");
		//System.out.println(htmlresult1);
		 

		
		String bio = "";
		Biology_Resultset br = new Biology_Resultset();
		if(br.checkAvailability(htmlresult6)){
		br.setProperty(htmlresult6);
		bio = br.getProperty();
		System.out.println(bio);
		Insert.insertBio(j, bio);
         //WriteOutput.output(line);
		}
		

	   ArrayList<String> general = new ArrayList();
		General_Resultset gr = new General_Resultset();
		if(gr.checkAvailability(htmlresult1)){
		gr.setProperty(htmlresult1);
		general = gr.getProperty();
		System.out.println( general.get(0)+","+ general.get(1)+","+ general.get(2)+","+ general.get(3)+","+ general.get(4)+","+ general.get(5)+","+ general.get(6)+","+ general.get(7)+","+ general.get(8)+","+ general.get(9)+","+ general.get(10));
		String line = general.get(0)+","+ general.get(1)+","+ general.get(2)+","+ general.get(3)+","+ general.get(4)+","+ general.get(5)+","+ general.get(6)+","+ general.get(7)+","+ general.get(8)+","+ general.get(9)+","+ general.get(10);
		Insert.insertGeneral(general.get(0), general.get(1), general.get(2), general.get(3), general.get(4), general.get(5), general.get(6), general.get(7), general.get(8),general.get(9), general.get(10));
		//WriteOutput.output(line);
		}
		
		ArrayList<String> ref = new ArrayList();
		Reference_Resultset re = new Reference_Resultset();
		//System.out.println(htmlresult2);
		if(re.checkAvailability(htmlresult2)){
		re.setProperty(htmlresult2);
		ref = re.getProperty();
		System.out.println(ref.get(0)+","+ ref.get(1)+","+ref.get(2)+","+ref.get(3));
		String line = ref.get(0)+","+ ref.get(1)+","+ref.get(2)+","+ref.get(3);
		Insert.insertReference(j, ref.get(0),ref.get(1) , ref.get(3),ref.get(2));
		//WriteOutput.output(line);
		}
		

		ArrayList<String> gly = new ArrayList<String>();
		Glycome_Resultset gl = new Glycome_Resultset();
		//System.out.println(htmlresult5);
		if(gl.checkAvailability(htmlresult5)){
		gl.setProperty(htmlresult5);
		gly = gl.getProperty();
		System.out.println(gly.get(0)+","+ gly.get(1)+","+gly.get(2)+","+gly.get(3));
		String line = gly.get(0)+","+ gly.get(1)+","+gly.get(2)+","+gly.get(3);
		Insert.insertGlycome(j, gly.get(0), gly.get(1), gly.get(2), gly.get(3));
		//WriteOutput.output(line);
		}
	
		ArrayList<String> pro = new ArrayList<String>();
		Proteome_Resultset pr = new Proteome_Resultset();
		//System.out.println(htmlresult4);
		if(pr.checkAvailability(htmlresult4)){
		pr.setProperty(htmlresult4);
		pro = pr.getProperty();
		System.out.println(pro.get(0)+","+ pro.get(1)+","+ pro.get(2)+","+pro.get(3));
		String line = pro.get(0)+","+ pro.get(1)+","+ pro.get(2)+","+pro.get(3);
		Insert.insertProteome(j,pro.get(1), pro.get(2),pro.get(3));
		//WriteOutput.output(line);
		}


		ArrayList<String> gen = new ArrayList<String>();
		Genome_Resultset ge = new Genome_Resultset();
		//System.out.println(htmlresult3);
		if(ge.checkAvailability(htmlresult3)){
		ge.setProperty(htmlresult3);
		gen = ge.getProperty();
		String line = gen.get(0)+","+ gen.get(1)+","+ gen.get(2)+","+ gen.get(3)+","+ gen.get(4)+","+ gen.get(5)+","+ gen.get(6)+","+ gen.get(7)+","+ gen.get(8);
		System.out.println(line);
		Insert.insertGenome(j, gen.get(0), gen.get(1), gen.get(2), gen.get(3), gen.get(4), gen.get(5), gen.get(6), gen.get(7), gen.get(8));

		}

		String enurl = "";
		Enzeme_URL en = new Enzeme_URL();
		
		if(en.checkAvailability(htmlresult2)){
			en.setProperty(htmlresult2);
			enurl = en.getProperty();
			System.out.println(enurl);
			Insert.insertEnzURL(j, enurl);
		}
		
		else{
			System.out.println("No this category of information");
	    }
		
		}
		**/

	}
}

