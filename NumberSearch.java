package coderbyte;

import java.util.Scanner;

public class NumberSearch {  
	
  String NumbrSearch(String str) { 
  
	  
	  int sum = 0;
	  int letCount = 0;
	  for (int i = 0; i < str.length(); i++) {
		
		  char c = str.charAt(i);
		  
		  if(Character.isDigit(c))
		  {
			  sum+=Character.getNumericValue(c);
		  }
		  
		  if(Character.isLetter(c))
		  {
			  letCount++;
		  }
	}

	  double dAns = (double)sum/letCount;
	  int iAns = sum/letCount;

	  double diff = dAns - iAns;
	  if(diff>=0.5)
		  iAns++;
	  
	  System.out.println(dAns);
    return String.valueOf(iAns);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    NumberSearch c = new NumberSearch();
    System.out.print(c.NumbrSearch(s.nextLine())); 
  }   
  
}








  