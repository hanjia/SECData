package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {
	public static void insertGeneral(String CFG_ID, String GBP_Name, String Category, String Sub_Family, String Other_Names, String Species, String Summary, String Subcellular_Location, String Last_Update_from_DB, String Last_Update_from_Contributors, String Contributors)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();
	           if(Subcellular_Location.contains("'")){
	        	   Subcellular_Location = Subcellular_Location.replace("'", "''");
	              }
	           if(Other_Names.contains("'")){
	        	   Other_Names = Other_Names.replace("'", "''");
	              }
	           
	           String sql = "insert into CFGAllData(CFG_ID, GBP_Name, Category, Sub_Family, Other_Names, Species, Summary, Subcellular_Location, Last_Update_from_DB, Last_Update_from_Contributors, Contributors)" + "values('"+ CFG_ID +"','"+ GBP_Name +"','" +  Category +"','"+ Sub_Family +"','"+  Other_Names+"','"+ Species +"','"+Summary +"','"+ Subcellular_Location +"','"+ Last_Update_from_DB +"','"+ Last_Update_from_Contributors +"','"+ Contributors +"')";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertReference(int id, String Recent_Literature, String Entrez_Gene, String SwissProt, String OMIM)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();
	          /** if(Subcellular_Location.contains("'")){
	        	   Subcellular_Location = Subcellular_Location.replace("'", "''");
	              }**/
	           id = id + 352;
	           String sql = "Update CFGAllData Set Recent_Literature ='"+ Recent_Literature +"', Entrez_Gene ='"+ Entrez_Gene +"', SwissProt = '" +  SwissProt +"', OMIM = '"+ OMIM +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertBio(int id, String Pathology)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();
	           id = id + 352;
	           if(Pathology.contains("'")){
	        	   Pathology = Pathology.replace("'", "''");
	              }
	           String sql = "Update CFGAllData Set Pathology = '"+ Pathology +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertGlycome(int id, String PrimaryGlycanBindingSpecificity,String ProposedGlycoprotein,String GlycanGBPInteraction, String PDBCitationsforLigands)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();
	           id = id +352;
	           if(PrimaryGlycanBindingSpecificity.contains("'")){
	        	   PrimaryGlycanBindingSpecificity = PrimaryGlycanBindingSpecificity.replace("'", "''");
	              }
	           if(ProposedGlycoprotein.contains("'")){
	        	   ProposedGlycoprotein = ProposedGlycoprotein.replace("'", "''");
	              }
	           if(GlycanGBPInteraction.contains("'")){
	        	   GlycanGBPInteraction = GlycanGBPInteraction.replace("'", "''");
	              }
	           if(PDBCitationsforLigands.contains("'")){
	        	   PDBCitationsforLigands = PDBCitationsforLigands.replace("'", "''");
	              }
	           String sql = "Update CFGAllData Set PrimaryGlycanBindingSpecificity = '"+ PrimaryGlycanBindingSpecificity +"', ProposedGlycoprotein = '"+ ProposedGlycoprotein +"', GlycanGBPInteraction = '" + GlycanGBPInteraction +"',PDBCitationsforLigands = '"+ PDBCitationsforLigands +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertProteome(int id,String Protein_Primary_Sequence,String Molecular_Weight, String PDB)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();

	           if(PDB.contains("'")){
	        	   PDB = PDB.replace("'", "''");
	              }

                id = id + 352;
	           String sql = "Update CFGAllData Set Protein_Primary_Sequence = '"+ Protein_Primary_Sequence +"', Molecular_Weight ='"+ Molecular_Weight +"', PDB ='" + PDB +"'  where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertGenome(int id,String Gene_Symbol,String Other_Gene_Names,String Gene_Ontology,String Nucleotide_Accession_Numbers,String Chromosome,String Unigene_Code,String Complete_CDS,String mRNA_size,String ORF)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();

	          // if(PDB.contains("'")){
	        //	   PDB = PDB.replace("'", "''");
	            //  }
               id = id + 352;
	           String sql = "Update CFGAllData Set Gene_Symbol = '"+ Gene_Symbol +"', Other_Gene_Names ='"+ Other_Gene_Names +"', Gene_Ontology ='" + Gene_Ontology +"' , Nucleotide_Accession_Numbers ='"+ Nucleotide_Accession_Numbers +"', Chromosome ='"+ Chromosome +"', Unigene_Code ='"+ Unigene_Code +"',Complete_CDS ='"+ Complete_CDS+"',mRNA_size ='"+ mRNA_size +"',ORF ='"+ ORF +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
	
	public static void insertURL(int id, String url)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();

	          if(url.contains("'")){
	           url = url.replace("'", "''");
	             }
               id = id + 352;
	           String sql = "Update cfgalldata set URL = '"+ url +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
		
	public static void insertEnzURL(int id, String EnzURL)
	{
		   try {
	           Class.forName("com.mysql.jdbc.Driver");
	       } catch(ClassNotFoundException ex) {
	           ex.printStackTrace();
	       }	        
	       Connection conn = null;       
	       Statement stmt = null;      
	       ResultSet rs = null;             
	       
	       try {	     
	           conn = DriverManager.getConnection
	               ("jdbc:mysql://localhost:3306/cfgdata","root","");	      
	           stmt = conn.createStatement();
	          /** if(Subcellular_Location.contains("'")){
	        	   Subcellular_Location = Subcellular_Location.replace("'", "''");
	              }**/
	           id = id + 352;
	           String sql = "Update CFGAllData Set Entrez_Gene_URL ='"+ EnzURL +"' where ID = "+id+"";
	           stmt.executeUpdate(sql);
	        
	//Database Connection
	           }
	       
	       catch (Exception ex) {
	           ex.printStackTrace();
	       }
	       finally {
	           try {
	               if(rs != null) {
	                   rs.close();
	               }
	               if(stmt != null) {
	                   stmt.close();
	               }
	               if(conn != null) {
	                   conn.close();
	               }
	           } catch(Exception ex) {
	               ex.printStackTrace();
	           }
	       }
	  }
}
