package coderbyte;

import java.util.*; 
import java.io.*;

public class NoughtsDeterminer {  
  String NoughtsDeterminer(String strArr) { 
  
  String[] sp = strArr.split(",");
  
  int ans = 0;
  
  int[] sol = {0,4,8, 1,5,9, 2,6,10, 0,1,2, 4,5,6, 8,9,10, 0,5,10, 2,5,8};
  
  int i = 0;
  
  while(i<24)
  {
	  String s1 = sp[sol[i++]];
	  String s2 = sp[sol[i++]];
	  String s3 = sp[sol[i++]];
	  
	  if(s1.equals("-") && s2.equals(s3) && !s2.equals("-"))
	  {
		  ans = sol[i-3];
		  break;
	  }
	  else
		  if(s2.equals("-") && s1.equals(s3) && !s1.equals("-"))
		  {
			  ans = sol[i-2];
			  break;
		  }
		  else
			  if(s3.equals("-") && s1.equals(s2) && !s1.equals("-"))
			  {
				  ans = sol[i-1];
				  break;
			  }
	  
  }
  
       
    return String.valueOf(ans);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    NoughtsDeterminer c = new NoughtsDeterminer();
    System.out.print(c.NoughtsDeterminer(s.nextLine())); 
  }   
  //X,O,-,<>,-,O,-,<>,O,X,-
  //X,-,O,<>,-,-,O,<>,-,-,X
}








  
