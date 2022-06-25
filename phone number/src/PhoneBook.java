import java.awt.TexturePaint;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class PhoneBook {
	
	// prints all of the db contents
	public void Print_all() {
	try{ 
		 
        FileReader fr=new FileReader("G:\\Java\\phone number\\src\\database") ;
        BufferedReader br=new BufferedReader(fr); 
        String line; 
        ArrayList<String> array= new ArrayList<String>();
        
        
        while((line=br.readLine())!=null)  
        { 
        array.add(line);
        }  
         
        System.out.println("Contents of File: "); 
        array.forEach((String) -> System.out.println(String));
		br.close();
        }catch(Exception e){System.out.println(e);}    
		System.out.println("Operation Successfull");
		
	}
	
	//THE FKING VALIDATION OF THE NUMBERS
	public boolean Check(String string) {
		// + 359 89 2 123456
		if (string.length()> 14) {
			//System.out.println(" string check");
			if(string.charAt(string.length()-7)>=('2') && string.charAt(string.length()-7)<=('9')) {
						//System.out.println(" 2 check");
						
						
						if((string.charAt(string.length()-8)==('7') || 
							string.charAt(string.length()-8)==('8') ||
							string.charAt(string.length()-8)==('9')) &&
							string.charAt(string.length()-9)==('8')
							) {
							//System.out.println(" 89 check");
							
							if (string.charAt(string.length()-10)!=('9')) {
								//System.out.println(" !9 check");
								
								if (string.charAt(string.length()-11)<=('0') && string.charAt(string.length()-11)<=('1') )  {
									//System.out.println(" 0 check");
									return true;
								}
							}else if(	string.charAt(string.length()-10)==('9') &&
										string.charAt(string.length()-11)==('5') &&
										string.charAt(string.length()-12)==('3')) 
									{
										//System.out.println(" 359 check");
										if (	string.charAt(string.length()-13)==('0')&& 
												string.charAt(string.length()-14)==('0') ) {
											//System.out.println(" 00 check");
											return true;
										} else if(string.charAt(string.length()-13)==('+')) {
											//System.out.println(" + check");
											return true;
										} else {	/*System.out.println(" wrong 1");*/	return false;}
									}else {		/*System.out.println(" wrong 2");*/	return false;}							
						} else {/*System.out.println(" wrong 3");*/	return false;}
				}else {/*System.out.println(" wrong 4");*/	return false;}
		} else {/*System.out.println(" wrong 5");*/	return false;}
		return false;
	}
	
	//READ + filter + sorted
	public void Read() {
		try{ 
			 
	        FileReader fr=new FileReader("G:\\Java\\phone number\\src\\database") ;
	        BufferedReader br=new BufferedReader(fr);   
	        String line; 
	        ArrayList<String> array= new ArrayList<String>();
	        
	        
	        while((line=br.readLine())!=null)  
	        { 
	        if(Check(line))array.add(line);
	        	
	        }  
	        
	        Collections.sort(array, new Comparator<String>() {
	            @Override
	            public int compare(String s1, String s2) {
	                return s1.compareToIgnoreCase(s2);
	            }
	        });
	        
	        System.out.println("Contents of File: "); 
	        array.forEach((String) -> System.out.println(String));
			br.close();
	        }catch(Exception e){System.out.println(e);}    
	        System.out.println("Operation Successfull");
			
		}
	
	//adds a line
	public void Add(String string){
		try {
			FileWriter fw=new FileWriter("G:\\Java\\phone number\\src\\database", true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			
			pw.println(string);
			
			pw.flush();
	        pw.close(); 
	        bw.close();
	        fw.close();
	        System.out.println("Operation Successfull");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//removes the line
	public void Remove(String name){
		try{ 
	        FileReader fr=new FileReader("G:\\Java\\phone number\\src\\database") ;
	        FileWriter fw=new FileWriter("G:\\Java\\phone number\\src\\database",true);
	        
	        //file out
	        BufferedReader br=new BufferedReader(fr);
	        String line; 
	        ArrayList<String> arrayList=new ArrayList<String>();
	        while((line=br.readLine())!=null)  
	        { 
	        	if(line.contains(name)==false) {
	        		arrayList.add(line);
	        	}

	        } 
	     	//file in
	        BufferedWriter bw= new BufferedWriter(fw);
	        PrintWriter pw=new PrintWriter(bw);
	        //clearing the file


	        
	        //new writer who don't save stuff just for the reset
	        FileWriter fw2=new FileWriter("G:\\Java\\phone number\\src\\database");
	        BufferedWriter bw2= new BufferedWriter(fw2);
	        PrintWriter pw2=new PrintWriter(bw2);
	        pw2.print("");
	        pw2.flush();
	        
	        for (int i = 0; i < arrayList.size(); i++) {
				pw.println(arrayList.get(i));
				pw.flush();
			}
	        
	        pw.close();
	        bw.close();
	        fw.close();
	        br.close();
	        System.out.println("Operation Successfull");
	       
	     }catch(Exception e){System.out.println(e);} 
	}

	//prints all of the lines containing name
	public void Search(String name){
		try{ 
			 
	        FileReader fr=new FileReader("G:\\Java\\phone number\\src\\database") ;
	        BufferedReader br=new BufferedReader(fr);   
	        String line; 
	            
	        while((line=br.readLine())!=null)  
	        { 
	        	if(line.contains(name)) System.out.println(line);	
	        }  
	        System.out.println("Operation Successfull");
	       br.close();
	     }catch(Exception e){System.out.println(e);}    
			
	}
	
	
}
