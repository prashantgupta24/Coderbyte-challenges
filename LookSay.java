package coderbyte;

import java.util.*; 
import java.io.*;

public class LookSay {  
  int LookSaySequence(int num) { 
  
    String str = Integer.toString(num);
    StringBuilder ans = new StringBuilder();
    
    int numTimes = 0;
    
    for (int i = 0; i < str.length(); i++) {
    	
    	int d1 = Character.getNumericValue(str.charAt(i));
    	numTimes = 1;
    	
    	while(i<str.length()-1)
    	{
    		int d2 = Character.getNumericValue(str.charAt(i+1));
    		if(d2==d1)
    		{
    			numTimes++;
    			i++;
    		}
    		else
    			break;
    	}
    	
    	ans.append(numTimes);
    	ans.append(d1);
	}
    
    
    return Integer.parseInt(ans.toString());
    
  }
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    LookSay c = new LookSay();
    System.out.print(c.LookSaySequence(Integer.parseInt(s.nextLine()))); 
  }   
  
}








  