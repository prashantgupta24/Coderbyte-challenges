package coderbyte;

import java.util.*; 

public class FarthestNode {  
  String FarthestNodes(String[] strArr) { 
  
	  ArrayList<String> vt = new ArrayList<String>();
	  HashMap<String, Integer> map = new HashMap<String, Integer>();
	  int size = 10;
	  int arr[][] = new int[size][size];
	  int vnum = 0;
	  
	  for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(i==j)
					arr[i][j] = 0;
				else
					arr[i][j] = 10000;
			}
	  }
	  
	  for (int i = 0; i < strArr.length; i++) {
		String s = strArr[i];
		
		String sp[] = s.split("-");
		if(!vt.contains(sp[0]))
		{
			vt.add(sp[0]);
			map.put(sp[0], vnum++);
		}
		if(!vt.contains(sp[1]))
		{
			vt.add(sp[1]);
			map.put(sp[1], vnum++);
		}
		
		arr[map.get(sp[0])][map.get(sp[1])] = 1;
		arr[map.get(sp[1])][map.get(sp[0])] = 1;
	}
	  
	 
	  
	  for (int k = 0; k < vt.size(); k++) {
		for (int i = 0; i < vt.size(); i++) {
			for (int j = 0; j < vt.size(); j++) {
				
				arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
			}
		}
	}
	  int max = 0;
	  for (int i = 0; i < vt.size(); i++) {
			for (int j = 0; j < vt.size(); j++) {
				if(arr[i][j]>max)
					max = arr[i][j];
			}
	  }
	  
    return String.valueOf(max);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    FarthestNode c = new FarthestNode();
   // System.out.print(c.FarthestNodes(new String[]{"b-e","b-c","c-d","a-b","e-f"})); 
    //System.out.print(c.FarthestNodes(new String[]{"b-a","c-e","b-c","d-c"})); 
    System.out.print(c.FarthestNodes(new String[]{"a-b","b-c","b-d"})); 
    //System.out.print(c.FarthestNodes(new String[]{"b-e","b-c","c-d","a-b","e-f"})); 
  }   
  
}








  
