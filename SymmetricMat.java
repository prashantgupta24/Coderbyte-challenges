package coderbyte;

import java.util.*; 
import java.io.*;

public class SymmetricMat {  
	
	int i=0, j=0;
	int mat[][] = new int[6][6];
	
  String SymmetricMatrix(String[] strArr) { 
  
	  i=0;j=0;
	  mat = new int[6][6];

  ArrayList<Integer> ar = new ArrayList<Integer>();
  
  for(int k=0; k<strArr.length;k++)
  {
	  String s = strArr[k];
	  
	  if(s.equals("<>"))
	  {
		  ar.add(j);
		  i++;
		  j=0;
		  continue;
	  }
	  
	  mat[i][j++] = Integer.parseInt(s);
  }
  ar.add(j);
  i++;
  
  int x = ar.get(0);
  for (int l = 1; l < ar.size(); l++) {
	if(ar.get(l)!= x)
		return "not possible";
  }
  
  if(i!=j)
	  return "not possible";

  for(int a=0;a<i;a++)
	{
		for(int b=0;b<j;b++)
		{
			if(a!=b)
			{
				if(mat[a][b] != mat[b][a])
					return "not symmetric";
			}
		}
	}
  
    return "symmetric";
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    SymmetricMat c = new SymmetricMat();
    System.out.print(c.SymmetricMatrix(new String[]{"1","2","4","<>","2","1","1","<>","-4","1","-1"}));
    System.out.print(c.SymmetricMatrix(new String[]{"1","0","1","<>","0","1","0","<>","1","0","1"}));
    System.out.print(c.SymmetricMatrix(new String[]{"1","1","1", "1", "<>","1","1","1", "1","<>", "1","1","1", "1", "<>", "1","1","1","1"}));
    
  }   
  
}








  