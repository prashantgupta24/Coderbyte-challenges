package coderbyte;

import java.util.*; 
import java.io.*;

public class TransitiveCheck {  

	String TransitivityRelations(String[] strArr) { 

		int mat[][] = new int[5][5];
		TreeSet<String> ts = new TreeSet<String>();
		
		int size = 0, a=0;

		for (int i = 0; i < strArr.length; i++) {

			String s = strArr[i];
			s = s.substring(s.indexOf('(')+1, s.indexOf(')'));
			String sp[] = s.split(",");
			size=sp.length;

			for(int j=0;j<size;j++)
			{
				mat[a][j] = Integer.parseInt(sp[j]);
			}
			a++;
		}

		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(i!=j && mat[i][j] != 0)
				{
					for(int k=0;k<size;k++)
					{
						if(j!=k && k!=i && mat[j][k] == 1)
						{
							if(mat[i][k] == 0)
							{
								ts.add("("+i+","+k+")-");
								mat[i][k] = 1;
							}
						}
					}
				}
			}
		}

		if(ts.size() == 0)
			return "transitive";
		else
		{
			String s = ts.toString();
			s = s.substring(s.indexOf('[')+1,s.indexOf(']')-1);
			s=s.replaceAll("-, ","-");
			return s.trim();
		}

	} 

	public static void main (String[] args) {  
		// keep this function call here     
		Scanner  s = new Scanner(System.in);
		TransitiveCheck c = new TransitiveCheck();
		//System.out.print(c.TransitivityRelations(new String[]{"(1,1,1)","(0,1,1)","(0,1,1)"}));
		System.out.print(c.TransitivityRelations(new String[]{"(1,1,0,0)","(0,0,1,0)","(0,1,0,1)","(1,0,0,1)"}));
		//System.out.print(c.TransitivityRelations(new String[]{"(1,1,1)","(1,0,0)","(0,1,0)"}));
	}   

}








  