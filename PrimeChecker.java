package coderbyte;

import java.util.*; 

class Function1 {  
	
	static boolean val[];
	static StringBuilder out = new StringBuilder();
	static boolean isPrme = false;
  
  boolean isPrime(int num)
  {
    for(int i=2;i<num/2;i++)
    {
      if(num%i == 0)
       return false;      
    }

      return true;
  }

  int PrimeChecker(int num) { 
	  

	  getCombi(num); 
		if(isPrme)
			return 1;
		else
			return 0;
	    
	  } 
  
  private void getCombi(int num) {
	
	  String s = String.valueOf(num);
	  
	  if(out.length() == s.length())
	  {
		  int val = Integer.parseInt(out.toString());
		if(isPrime(val))
		{
			//System.out.println(val);
		        isPrme = true;
		}
	  }
	  for(int i=0;i<s.length();i++)
	  {
		  if(val[i])
			  continue;
		  val[i] = true;
		  out.append(s.charAt(i));
		  getCombi(Integer.parseInt(s));
		  val[i] = false;
		 out.setLength(out.length()-1);
	  }
}

public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function1 c = new Function1();
    val = new boolean[20];
    System.out.print(c.PrimeChecker(Integer.parseInt(s.nextLine())));
  }   
  
}           
