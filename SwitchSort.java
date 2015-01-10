package coderbyte;

import java.util.*; 
import java.io.*;

public class SwitchSort {  
	
	int size = 0;
	ArrayList<Integer> org = new ArrayList<Integer>();
	int finalAns = 0;
	
  int SwitchSort(int[] arr) { 
  
	  size = arr.length;
	
   TreeSet<Integer> ts =  new TreeSet<Integer>();
   HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();
   
   for (int i = 0; i < size; i++) {
	   org.add(arr[i]);
	ts.add(arr[i]);
}
   
   ArrayList<Integer> ar = new ArrayList<Integer>(ts);
   for (int i = 0; i < ar.size(); i++) {
	val.put(ar.get(i), i);
}
   
   int i=0;
   int count = 0;
   boolean bol = true;
   
  while(true)
  {
	  
	  if(val.get(org.get(i)) != i)
	  {
		  count++;
		  int left = lftXch(i);
		  int right = rtXch(i);

		  if(val.get(org.get(left)) == i || val.get(org.get(i)) == left)
		  {
			  doExch(i, left);
		  }
		  else 
			  if(val.get(org.get(right)) == i || val.get(org.get(i)) == right)
			  {
				  doExch(i, right);
			  }
	  }
	  
	  if(i==size-1)
	  {
		  i=0;
		  if(count == 0)
			  break;
		  else
			  count = 0;
	  }
	  else
		  i++;
  }
   
       
    return finalAns;
    
  }
  
  private void doExch(int orgIn, int repIndex) {
	  finalAns++;
	  int temp = org.get(repIndex);
	  
	  org.set(repIndex, org.get(orgIn));
	  org.set(orgIn, temp);
	
}

  int lftXch(int index)
  {
	  int ans = 0;
	  int diff = index-org.get(index);
	  if(diff >= 0)
		  ans = diff;
	  else
	  { 
		  int s = size;
		  diff = Math.abs(diff);
		  while(s - diff < 0)
		  {
			  s = s+size;
		  }
		  ans = s - diff;

	  }

	  return ans;

  }
  
  int rtXch(int index)
  {
	  int ret = (index+org.get(index))%size; 
	  return ret;
  }
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    SwitchSort c = new SwitchSort();
    //System.out.print(c.SwitchSort(new int[]{7,3,1,5,6})); 
    System.out.print(c.SwitchSort(new int[]{9,3,2})); 
   // System.out.print(c.SwitchSort(new int[]{1,3,4,2})); 
   // System.out.print(c.SwitchSort(new int[]{7,3,1,5,6})); 
    
  }   
  
}








  