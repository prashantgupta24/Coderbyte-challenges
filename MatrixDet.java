package coderbyte;

import java.util.*; 
import java.io.*;

public class MatrixDet {  
	
	int i=0, j=0;
	int mat[][] = new int[6][6];
	
  String MatrixDeterminant(String[] strArr) { 
	  
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
		return String.valueOf(-1);
  }
  
  if(i!=j)
	  return String.valueOf(-1);

  int res = calDet(mat, i, j);
  
    return String.valueOf(res);
    
  } 
  
  private int calDet(int m[][], int i, int j) {
	
	int res = 0;
	
	for(int k=0;k<j;k++)
	{
		if(j==2)
			return m[0][0]*m[1][1] - m[1][0]*m[0][1];
		else
		{
			if(k%2!=0)
			{
				res+= -1*m[0][k]*(calDet(makeMat(m,i,j,k), i-1,j-1));
			}
			else
			{
				res+= m[0][k]*(calDet(makeMat(m,i,j,k), i-1,j-1));
			}
		}
	}
	
	return res;
}
  
  private int[][] makeMat(int m[][], int i, int j, int k)
  {
	  int x = 0;
	  int y = 0;
	  int fmat[][] = new int[i-1][j-1];
	  
	  for(int a=1;a<i;a++)
	  {
		  for(int b=0;b<j;b++)
		  {
			  if(b!=k)
			  {
				  if(y==j-1)
				  {
					  x++;
					  y=0;
				  }
				  
				  fmat[x][y++] = m[a][b];
			  }
		  }
	  }
	  
	  return fmat;
  }

public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    MatrixDet c = new MatrixDet();
    System.out.print(c.MatrixDeterminant(new String[]{"5","0","<>","0","5"}));
    System.out.print(c.MatrixDeterminant(new String[]{"1","2","<>","3","4"}));
    System.out.print(c.MatrixDeterminant(new String[]{"1","2","4","<>","2","2","1","<>","4","1","1"}));
    System.out.print(c.MatrixDeterminant(new String[]{"1","2","4", "5", "<>","2","2","1", "1","<>", "4","1","1", "4", "<>", "7","2","4", "5"}));
    System.out.print(c.MatrixDeterminant(new String[]{"2","1","1","<>","1","1","4","<>","2","4","5"}));
//    System.out.print(c.MatrixDeterminant(new String[]{"5","0","<>","0","5"}));
    
  }   
  
}








  