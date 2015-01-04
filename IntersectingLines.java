package coderbyte;

import java.util.*; 
import java.io.*;

public class IntersectingLines {  
	
  String IntersectingLines(String strArr) { 
  
	  strArr = strArr.trim();
	  
   String[] input = strArr.split(",");
   
   //int x1 = (input[0].charAt(1));
   int x1 = Integer.parseInt(input[0]);
   int y1 = Integer.parseInt(input[1]);
   int x2 = Integer.parseInt(input[2]);
   int y2 = Integer.parseInt(input[3]);
   int x3 = Integer.parseInt(input[4]);
   int y3 = Integer.parseInt(input[5]);
   int x4 = Integer.parseInt(input[6]);
   int y4 = Integer.parseInt(input[7]);
   
   
   int numM1 = y2-y1;
   int denM1 = x2-x1;
   if(numM1 < 0 && denM1 < 0)
   {
	   numM1 = Math.abs(numM1);
	   denM1 = Math.abs(denM1);
   }
   
   int numM2 = y4-y3;
   int denM2 = x4-x3;

   if(numM2 < 0 && denM2 < 0)
   {
	   numM2 = Math.abs(numM2);
	   denM2 = Math.abs(denM2);
   }
   
   if(numM1 == numM2 && denM1 == denM2)
	   return "No Intersection";
   
   int left1 = (y2*-1)*denM1*denM2;
   int left2 = (y4*-1)*denM1*denM2;
   
   int finalLeft = left1-left2;
   
   int right1 = (x2*-1)*numM1*denM2;
   int right2 = (x4*-1)*numM2*denM1;
      int finalRight = right1-right2;
   
   finalLeft = finalLeft - finalRight;
   
   int finalAnsNumX = finalLeft;
   int finalAnsDenX = numM1*denM2 - numM2*denM1;
  int fact = factorize(finalAnsNumX, finalAnsDenX);
  
  finalAnsNumX = finalAnsNumX/fact;
  finalAnsDenX = finalAnsDenX/fact;
  
  if(finalAnsNumX < 0 && finalAnsDenX < 0)
  {
	  finalAnsNumX = Math.abs(finalAnsNumX);
	  finalAnsDenX = Math.abs(finalAnsDenX);
  }
 // System.out.println(finalAnsNumX+"/"+finalAnsDenX);
  
  left1 = (y2*-1)*denM1*finalAnsDenX;
  
  right1 = (finalAnsNumX -(finalAnsDenX*x2))*numM1;
  
  
  finalLeft = right1-left1;
  
  finalRight = denM1*finalAnsDenX;
  
  fact = factorize(finalLeft, finalRight);
  
  finalLeft = finalLeft/fact;
  finalRight = finalRight/fact;
  
  if(finalLeft < 0 && finalRight < 0)
  {
	  finalLeft = Math.abs(finalLeft);
	  finalRight = Math.abs(finalRight);
  }
  

  
  if(finalAnsDenX < 0)
  {
	  finalAnsNumX = finalAnsNumX*-1;
	  finalAnsDenX = finalAnsDenX*-1;
  }
  
  if(finalRight < 0)
  {
	  finalLeft = finalLeft*-1;
	  finalRight = finalRight*-1;
  }
  
  if(finalAnsDenX == 1  && finalRight == 1)
	  return finalAnsNumX+" , "+finalLeft; 
  else
  if(finalAnsDenX == 1 )
	  return finalAnsNumX+" , "+finalLeft+"/"+finalRight;
  else
	  if(finalRight == 1)
		  return finalAnsNumX+"/"+finalAnsDenX+" , "+finalLeft;
		  else
			  return finalAnsNumX+"/"+finalAnsDenX+" , "+finalLeft+"/"+finalRight; 

   //return strArr;
    
  } 
  

private int factorize(int n1, int n2) {
	  
	  n1 = Math.abs(n1);
	  n2 = Math.abs(n2);
	
	  if(n1==n2)
		  return n1;
	  
	  if(n1>n2)
	  {
		  if(n1 % n2 ==0)
				return n2;
		  else
		  {
			 return factorize(n2, n1-n2);
		  }
	  }
	  else
	  {
		  if(n2 % n1 ==0)
				return n1;
		  else
			 return factorize(n2-n1, n1);
	  }
}

public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    IntersectingLines c = new IntersectingLines();
    System.out.print(c.IntersectingLines(s.nextLine())); 
  }   
 //3,0,1,4,0,-3,2,3 
//9,-2,-2,9,3,4,10,11
//1,2,3,4,-5,-6,-7,-8
//3,0,1,4,0,-3,2,3
//0,15,3,-12,2,1,13,7
}








  