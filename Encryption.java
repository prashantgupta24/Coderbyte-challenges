package coderbyte;

import java.util.ArrayList;
import java.util.Scanner;

public class Encryption {  
	
	int last = 0;

	StringBuilder st = new StringBuilder();
	  ArrayList<Character> ans = new ArrayList<Character>();

  String AlphabetRunEncryption(String str) { 

	  
	  for (int i = 0; i < str.length(); i++) {
		  
		  if(i>0)
		  {
			  if(str.charAt(i)!= 'R' && str.charAt(i)!= 'L' && str.charAt(i)!= 'S' && str.charAt(i)!= 'N' )
			  {
				  if(st.charAt(i-1) == str.charAt(i) || (i>last) && (Math.abs(st.charAt(i-1) - str.charAt(i)) > 1))
				  {
					  doSom(st.substring(last, i));
					  last = i;
				  }
			  }
		  }
		  
			  if(str.charAt(i) == 'R')
			  {
				  int c = (int)str.charAt(i-1);
				  if(last<i-1)
					  doSom(st.substring(last, i-1));
				  int ac1 = c-1;
				  int ac2 = c+1;
				  if(ans.size()>0 && ans.get(ans.size()-1) == (char)ac1)
					{
						ans.add((char)ac2);
					}
				  else
				  {
				  ans.add((char)ac1);
				  ans.add((char)ac2);
				  }
				  last = i+1;
			  }

			  if(str.charAt(i) == 'L')
			  {
				  int c = (int)str.charAt(i-1);
				  if(last<i-1)
					  doSom(st.substring(last, i-1));
				  int ac1 = c+1;
				  int ac2 = c-1;
				  if(ans.size()>0 && ans.get(ans.size()-1) == (char)ac1)
					{
						ans.add((char)ac2);
					}
				  else
				  {
				  ans.add((char)ac1);
				  ans.add((char)ac2);
				  }
				  last = i+1;

			  }

			  if(str.charAt(i) == 'S')
			  {
				  //st.setLength(st.length()-1);
				  if(last<i-2)
					  doSom(st.substring(last, i-2));
				  int ac1 = (int)str.charAt(i-2);
				  int ac2 = (int)str.charAt(i-1);
				  if(ans.size()>0 && ans.get(ans.size()-1) == (char)ac1)
					{
						ans.add((char)ac2);
					}
				  else
				  {
				  ans.add((char)ac1);
				  ans.add((char)ac2);
				  }
				  last = i+1;
			  }

			  if(str.charAt(i) == 'N')
			  {
				  int c = (int)str.charAt(i-1);
				  if(last<i-1)
					  doSom(st.substring(last, i-1));
				  ans.add((char)c);
				  last = i+1;
			  
			  }
			  
			  st.append(str.charAt(i));
	}
	  
	  if(st.length() > 0 && last<st.length()-1)
		  doSom(st.substring(last, st.length()));
	  
	  
	  StringBuilder fans = new StringBuilder();
	  for (int j = 0; j < ans.size(); j++) {
		fans.append(ans.get(j));
	}
    return fans.toString();
    
  } 
  
  private void doSom(String st) {

	  if((int)st.charAt(1)>(int)st.charAt(0))
	{
		int ac1 = ((int)st.charAt(0))-1;
		int ac2 = ((int)st.charAt(st.length()-1))+1;
		if(ans.size()>0 && ans.get(ans.size()-1) == (char)ac1)
		{
			ans.add((char)ac2);
		}
		else
		{
			ans.add((char)ac1);
			ans.add((char)ac2);
		}
	}
	else
	{

		int ac1 = ((int)st.charAt(0))+1;
		int ac2 = ((int)st.charAt(st.length()-1))-1;
		if(ans.size()>0 && ans.get(ans.size()-1) == (char)ac1)
		{
			ans.add((char)ac2);
		}
		else
		{
			ans.add((char)ac1);
			ans.add((char)ac2);
		}
	
	}
}

public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Encryption c = new Encryption();
    System.out.print(c.AlphabetRunEncryption(s.nextLine())); 
  }   
  
}








  