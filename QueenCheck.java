package coderbyte;

import java.util.Scanner;

public class QueenCheck {  
	
  String QueenCh(String[] strArr) { 
  
	  int numMoves = 0;
	  String s1 = strArr[0];
	  String s2 = strArr[1];
	  
	  s1 = s1.substring(s1.indexOf('(')+1,s1.indexOf(')'));
	  s2 = s2.substring(s2.indexOf('(')+1,s2.indexOf(')'));
       
	  int qx = Character.getNumericValue(s1.charAt(0));
	  int qy = Character.getNumericValue(s1.charAt(2));
	  
	  int kx = Character.getNumericValue(s2.charAt(0));
	  int ky = Character.getNumericValue(s2.charAt(2));
			  
	  if(!isCheck(qx, qy, kx, ky))
		  return String.valueOf(-1);
	  
	  for (int i=-1;i<2;i++) 
	  {
		for(int j=-1;j<2;j++)
		{
			if(i==0 && j==0)
				continue;
			
				if(kx+i>0 && kx+i<9 && ky+j >0 && ky+j <9 && !isCheck(qx, qy, kx+i, ky+j))
					numMoves++;
				
				if(qx == kx+i && qy == ky+j)
					numMoves++;
		}
	  }
	  
	  return String.valueOf(numMoves);
  } 
  
  boolean isCheck(int qx, int qy, int kx, int ky)
  {
	  if(qx == kx || qy == ky)
		  return true;
	  
	  if(Math.abs(qx-kx) == Math.abs(qy-ky))
		  return true;

	  return false;
  }
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    QueenCheck c = new QueenCheck();
    System.out.println(c.QueenCh(new String[]{"(1,1)", "(2,2)"}));
    System.out.println(c.QueenCh(new String[]{"(1,1)", "(2,3)"}));
    System.out.println(c.QueenCh(new String[]{"(4,5)", "(6,5)"}));
    System.out.println(c.QueenCh(new String[]{"(4,5)", "(6,7)"}));
    //System.out.print(c.QueenCh(s.nextLine())); 
  }   
  //(1,1),(2,2)
}








  