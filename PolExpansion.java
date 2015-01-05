package coderbyte;

import java.util.*; 
import java.io.*;

public class PolExpansion {  
	
	 int cx = 0, px = 0, v = 0, cx1 = 0, cx2 = 0, px1 = 0, px2 = 0, v1 = 0, v2 = 0;
	    char var;
	    
	    StringBuilder s = new StringBuilder("");
	    int n = 0;
	    
  String PolynomialExpansion(String str) { 
  
    String s1 = str.substring(str.indexOf('(')+1,str.indexOf(')'));
    String s2 = str.substring(str.lastIndexOf('(')+1, str.length()-1);
    
    setVar(s1);
    cx1 = cx;
    v1 = v;
    px1 = px;
    
    s = new StringBuilder("");
    n = 0;
    
    setVar(s2);
    
    cx2 = cx;
    v2 = v;
    px2 = px;
    
    System.out.println(s1);
 System.out.println(cx1+" "+px1+" "+v1);
 
 System.out.println(s2);
 System.out.println(cx2+" "+px2+" "+v2);
 
 
 StringBuilder ans = new StringBuilder();
 
 	if(px1 != 0 && px2 != 0)
 	{
 		ans.append(cx1*cx2);
 		ans.append(var+"^");
 		ans.append(px1+px2);
 		ans.append("+");

 		if(px1 > px2)
 		{
 			if(v2 != 0)
 			{
 				ans.append(cx1*v2);
 				ans.append(var+"^");
 				ans.append(px1);
 				ans.append("+");
 			}

 			if(v1 != 0)
 			{
 				ans.append(cx2*v1);
 				ans.append(var+"^");
 				ans.append(px2);
 				ans.append("+");

 			}

 		}
 		else
 		{
 			if(v1 != 0)
 			{
 				ans.append(cx2*v1);
 				ans.append(var+"^");
 				ans.append(px2);
 				ans.append("+");

 			}


 			if(v2 != 0)
 			{
 				ans.append(cx1*v2);
 				ans.append(var+"^");
 				ans.append(px1);
 				ans.append("+");
 			}
 		}
 	}
 	
 	if(v1!=0 && v2!=0)
 	{
 		ans.append(v1*v2);
 	}
       
 	
    return ans.toString();
    
  } 
  
  void setVar(String s1)
 {
		try {
			n = Integer.parseInt(s1);
		} catch (Exception e) {

			if (s1.indexOf('^') == -1) {
				px = 1;
			}

			for (int i = 0; i < s1.length(); i++) {

				char c = s1.charAt(i);

				if (c == '^')
					continue;

				s.append(c);

				if (s.toString().equals("-"))
					continue;

				try {
					n = Integer.parseInt(s.toString());
				} catch (Exception e1) {
					if (Character.isLetter(c)) {
						cx = n;
						var = c;
						s = new StringBuilder("");
					} else if (cx == 0) {
						v = n;
						s = new StringBuilder(c);
					} else {
						px = n;
						s = new StringBuilder("");
					}

					n = 0;
				}

			}

			if (v == 0 && cx == 0)
				v = n;
			else if (px == 0)
				px = n;
			return;
		}
		
		v = n;
	}
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    PolExpansion c = new PolExpansion();
    //System.out.print(c.PolynomialExpansion("(1x)(2x^-2+1)"));
    //System.out.println(c.PolynomialExpansion("(2x^2+4)(6x^3+3)"));
//    System.out.println(c.PolynomialExpansion("(2x^2+4)(6x^3+3)"));
//    System.out.println(c.PolynomialExpansion("(2x^2+4)(6x^3+3)"));
    System.out.println(c.PolynomialExpansion("(-1x^3)(3x^3+2)"));
    
  }   
  
}








  