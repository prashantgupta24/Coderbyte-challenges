package coderbyte;

import java.util.*; 

public class BlackJack {  
  String BlackjackHighest(String strArr) { 
  
	String str[] = strArr.split(",");  
	  
  HashMap<String, Integer> values = new HashMap<String, Integer>();
       
  values.put("ace", 11);
  values.put("two", 2);
  values.put("three", 3);
  values.put("four", 4);
  values.put("five", 5);
  values.put("six", 6);
  values.put("seven", 7);
  values.put("eight", 8);
  values.put("nine", 9);
  values.put("ten", 10);
  values.put("jack", 10);
  values.put("queen", 10);
  values.put("king", 10);
  
  HashMap<Integer, String> revValues = new HashMap<Integer, String>();
  
  revValues.put(2, "two");
  revValues.put(3,"three");
  revValues.put(4, "four");
  revValues.put(5, "five");
  revValues.put(6, "six");
  revValues.put(7, "seven");
  revValues.put(8, "eight");
  revValues.put(9, "nine");

  StringBuilder ans = new StringBuilder();
  int finalValue = 0;
  int j = 0;
  int q = 0;
  int k = 0;
  int a = 0;
  int t = 0;
  int max = 0;
  
  for (int i = 0; i < str.length; i++) {
	
	String key = str[i];
	int value = values.get(key);
	if(value > max && value < 10)
		max = value;
	
	finalValue+= value;   
	
	if(key.equals("ace"))
		a++;
	if(key.equals("jack"))
		j++;
	if(key.equals("queen"))
		q++;
	if(key.equals("king"))
		k++;
	if(key.equals("ten"))
		t++;
}
  
  if(finalValue > 21 && a>0)
  {
	  while(a>0 && finalValue >21)
	  {
		  finalValue = finalValue - 10;
		  a--;
	  }
  }

  
	  if(finalValue > 21)
		  ans.append("above ");
  else
	  if(finalValue<21)
		  ans.append("below ");
	  else
		  ans.append("blackjack ");
  
	  
	  if(a>0)
		  ans.append("ace");
	  else
		  if(j>0)
			  ans.append("jack");
			  else
				  if(q>0)
					  ans.append("queen");
				  else
					  if(k>0)
						  ans.append("king");
					 else
						 if(t>0)
							 ans.append("ten");
						 else
							 ans.append((String.valueOf(revValues.get(max))));
	 
    return ans.toString();
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    BlackJack c = new BlackJack();
    System.out.print(c.BlackjackHighest(s.nextLine())); 
  }   
  //four,ace,ten
  //ace,queen
  //two,three,ace,king
  //four,ten,king
  //ace,ace,ace,eight
  //four,four,four,four,four,ace
  //two,three,four,five,six,ace
}








  