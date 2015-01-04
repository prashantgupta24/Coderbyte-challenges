package coderbyte;

import java.util.*;

public class Hamiltonian {  
	
	ArrayList<String> ed = new ArrayList<String>();
	
  String HamiltonianPath(String[] strArr) { 
  
	  
	   ArrayList<String> vt = new ArrayList<String>();
	   
	   ArrayList<String> vtF = new ArrayList<String>();
	   ArrayList<String> vstd = new ArrayList<String>();
	   
	  String s1 = strArr[0];
	  String s2 = strArr[1];
	  String s3 = strArr[2];
	  s1 = s1.substring(s1.indexOf('(')+1,s1.indexOf(')'));
	  s2 = s2.substring(s2.indexOf('(')+1,s2.indexOf(')'));
	  s3 = s3.substring(s3.indexOf('(')+1,s3.indexOf(')'));
	  
	  String s[] = s1.split(",");
	  for (int i = 0; i < s.length; i++) {
		vt.add(s[i]);
	}
	  s = s2.split(",");
	  for (int i = 0; i < s.length; i++) {
			ed.add(s[i]);
		}
	  
	  s = s3.split(",");
	  for (int i = 0; i < s.length; i++) {
			vtF.add(s[i]);
		}

   
	  vstd.add(vtF.get(0));
	  
	  for (int i = 0; i < vtF.size()-1; i++) {
		
		  String v1 = vtF.get(i);
		  
		  String v2 = vtF.get(i+1);
		  if(!vstd.contains(v2))
			  vstd.add(v2);
		  else
			  return v2;
		  
		  if(!isPath(v1,v2))
			  return v1;
	}
	  
    return "yes";
    
  } 
  
  private boolean isPath(String v1, String v2) {
	
	String s1 = v1+"-"+v2;
	String s2 = v2+"-"+v1;
	
	if(ed.contains(s1) || ed.contains(s2))
		return true;
	else
		return false;
}

public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Hamiltonian c = new Hamiltonian();
    //System.out.print(c.HamiltonianPath(new String[]{"(A,B,C)","(B-A,C-B)","(C,B,A)"})); 
    //System.out.print(c.HamiltonianPath(new String[]{"(X,Y,Z,Q)","(X-Y,Y-Q,Y-Z)","(Z,Y,Q,X)"}));
    System.out.print(c.HamiltonianPath(new String[]{"(A,B,C,D)","(A-B,A-D,B-D,A-C)","(D,A,B,C)"}));
  }   
  
}








  