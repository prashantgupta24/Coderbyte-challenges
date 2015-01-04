package coderbyte;

import java.util.Scanner;

public class PatternMatching {  
	String PatternChaser(String str) {
		
		//FirstTry
		
		/* 
		TreeMap<Integer, String> tm = new TreeMap();

		for (int i = 0; i < str.length(); i++) 
		{
			char c1 = str.charAt(i);
			
			
			for(int j=i+1; j<str.length();j++)
			{
				char c2 = str.charAt(j);
				StringBuilder ans = new StringBuilder();
				int m=1;int n=1;
				while(c1==c2 && (j+n) < str.length() )
				{
					char c11 = str.charAt(i+m++);
					char c12 = str.charAt(j+n++);

					if(c11!=c12)
					{
						break;
					}
					ans.append(c1);
					ans.append(c11);
				}
				if(ans.length()>0)
					tm.put(ans.length(), ans.toString());
			}
		}

		Entry e = tm.pollLastEntry();
		return (String)e.getValue();
	*/
		
		//Solution
/*		String pattern = "";
        for (int x = 0; x < str.length(); x++) {
            String current = str.charAt(x) + "";
            for (int y = x + 1; y < str.length(); y++) {
                String tmp = str;
                current += str.charAt(y);
                tmp = tmp.replace(current, "!");
                int count = 0;
                for (int z = 0; z < tmp.length(); z++) {
                    if (tmp.charAt(z) == '!') {
                        count++;
                    }
                }
                if (count > 1 && current.length() > pattern.length()) {
                    pattern = current;
                }
            }
        }
        if (pattern.equals("")) {
            return "no null";
        }
        return "yes " + pattern;	
	
	*/
	
		//SOlution2
/*	    String test = "";
	    String longest = "";
	    int size = 2;
	    while(size <= str.length()/2)
	    {
	      for(int i = 0; i < str.length()-test.length()+1; i++)
	      {
	        test = str.substring(i,i+size);
	        if(str.indexOf(test) != str.lastIndexOf(test))
	        {
	          longest = new String(test);
	        }
	      }
	      size++;
	    }
	    
	    if(longest.equals(""))
	    {
	      return "no null";
	    }
	    else
	    {
	      return "yes " + longest;
	    }*/
		
		
		
		
		
		
		
		String ans = "";
		String check = "";
		int size = 2;

		while(size<str.length()/2)
		{
			for(int i=0;i<str.length()-size+1;i++)
			{
				check = str.substring(i,i+size);
				if(str.indexOf(check) != str.lastIndexOf(check))
				{
					ans = check;
				}
			}
			
			size++;
		}
		
	if(ans != "")
		return "yes "+ans;
	else
		return "No null";
	} 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    PatternMatching c = new PatternMatching();
    System.out.print(c.PatternChaser(s.nextLine())); 
  }   
  
}           
