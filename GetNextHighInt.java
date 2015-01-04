package coderbyte;

import java.util.ArrayList;
import java.util.Scanner;

public class GetNextHighInt {  
  int PermutationStep(int num) { 
	  
	  boolean isPoss = false;
	  ArrayList<Integer> list = new ArrayList();
	  int temp = num;
	  int lastNum = 0;
	  while(temp > 0)
	  {
		  int n = temp%10;
		  
		  list.add(0,n);
		  temp = temp/10;
		  
		  if(n>=lastNum)
			  lastNum = n;
		  else
		  {
			  isPoss = true;
			  break;
		  }
	  }
	  
	  int listSize = list.size();
	  int first = list.get(0);
	  if(listSize == 1)
		  return first;
	 
	  int secMin = list.get(1);
	  for (int i = 2; i < listSize; i++) {
		int no = list.get(i);
		if(no< secMin && no>first)
			secMin = no;	  
	}

	  double ans = 0;
	  int tempLSize = list.size();
	  while(temp>0)
	  {
		  int n = temp%10;
		  ans += n*(Math.pow(10, tempLSize++));
		  temp = temp/10;
	  }
	  ans += secMin*(Math.pow(10, --listSize));
	  ans += first*(Math.pow(10, --listSize));
	  list.remove(0);
	  list.remove(Integer.valueOf(secMin));
	  
	  int k=0;
	 while(listSize>0)
	 {
		 ans += list.get(k)*(Math.pow(10, --listSize));
		 k++;
	 }
	  
	if(isPoss)
		return (int)ans;
	else
		return -1;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    GetNextHighInt c = new GetNextHighInt();
    System.out.println(c.PermutationStep(Integer.parseInt(s.nextLine()))); 
    //c.PermutationStep(Integer.parseInt(s.nextLine()));
  }   
  
}








  