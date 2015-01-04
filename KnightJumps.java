package coderbyte;

import java.util.Scanner;

public class KnightJumps {  
  String KnightJumps(String str) { 
  
	  int numMoves = 0;
    str = str.substring(str.indexOf('(')+1,str.indexOf(')'));
    String sp[] = str.split(" ");

    int x = Integer.parseInt(sp[0]);
    int y = Integer.parseInt(sp[1]);
    
    if(x-2>0)
    {
    	if(y-1>0)
    		numMoves++;
    	if(y+1<9)
    		numMoves++;
    }
   
    if(x+2<9)
    {
    	if(y-1>0)
    		numMoves++;
    	if(y+1<9)
    		numMoves++;
    }
    if(y+2<9)
    {
    	if(x-1>0)
    		numMoves++;
    	if(x+1<9)
    		numMoves++;
    }
    if(y-2>0)
    {
    	if(x-1>0)
    		numMoves++;
    	if(x+1<9)
    		numMoves++;
    }
    return String.valueOf(numMoves);
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    KnightJumps c = new KnightJumps();
    System.out.print(c.KnightJumps(s.nextLine())); 
  }   
  
}








  