package coderbyte;

import java.util.*; 
import java.io.*;

public class PolExpansion {  
  String PolynomialExpansion(String str) { 
  
    String s1 = str.substring(str.indexOf('(')+1,str.indexOf(')'));
    String s2 = str.substring(str.lastIndexOf('(')+1, str.length()-1);
    
    int cx1, cx2, px1, px2, v1, v2 = 0;
    char var;
    
    StringBuilder s = new StringBuilder("");
    
    for (int i = 0; i < s1.length(); i++) {
		
    	char c= s1.charAt(i);
    	
    	if(!Character.isLetter(c))
    		s.append(c);
    	else
    	{
    		var = c;
    		cx1 = Integer.parseInt(s.toString());
    	}
	}
       
    return str;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    PolExpansion c = new PolExpansion();
    System.out.print(c.PolynomialExpansion("(1x)(2x^-2+1)")); 
  }   
  
}








  