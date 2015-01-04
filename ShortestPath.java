package coderbyte;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ShortestPath {  
	
  String path(String strArr) { 
  
  String[] str = strArr.split(",");
  
  	int numNodes = Integer.parseInt(str[0]);
  	
  	ArrayList<String> nodes = new ArrayList();
  	ArrayList<String> edges = new ArrayList();
  	ArrayList<String> winCircle = new ArrayList();
  	TreeMap<String, Integer> dis = new TreeMap();
  	TreeMap<String, TreeMap> main = new TreeMap();
  	TreeSet<String> minNode = new TreeSet();
  	
  	for(int i=0;i<numNodes;i++)
  	{
  		nodes.add(str[i+1]);
  	}
  	
  	for(int i=numNodes+1;i<str.length;i++)
  	{
  		edges.add(str[i]);
  	}
  	
  	winCircle.add(nodes.get(0));
  	String firstNode = nodes.get(0);
  	dis.put(firstNode,0);
  	main.put(firstNode, dis);
  	
  	int orgDist = 0;
  	while(winCircle.size() != nodes.size())
 {
			for (int i = 0; i < winCircle.size(); i++) {
				String winNode = winCircle.get(i);
				for (int j = 0; j < nodes.size(); j++) {
					String node = nodes.get(j);
					if (winCircle.contains(node))
						continue;
					else {
						String edge = winNode + "-" + node;
						if (edges.contains(edge)) {
							dis = new TreeMap();
							TreeMap mOrg = main.get(node);
							TreeMap mNew = main.get(winNode);
							if (mOrg != null)
								orgDist = (int) mOrg.get(mOrg.firstKey());
							else
								orgDist = 1000;
							int newDist = (int) mNew.get(mNew.firstKey());
							if (newDist + 1 < orgDist) {
								minNode.add((newDist + 1)+node);
								dis.put(winNode, newDist + 1);
								main.put(node, dis);
							} else
								minNode.add(orgDist+node);
						}
					}
				}

			}
			while(true)
			{
				String first = minNode.first();
				String nodeToAdd = first.substring(first.length()-1);
				if(!winCircle.contains(nodeToAdd))
				{
					winCircle.add(nodeToAdd);
					minNode = new TreeSet();
					break;
				}
			}
		}
  	
  	String lastNode = nodes.get(numNodes-1);
  	String node = lastNode;
  	StringBuilder ans = new StringBuilder(lastNode);
  	do
  	{
  		TreeMap t = main.get(node);
  		node = (String) t.firstKey();
  		ans.append(node);
  		
  	}while(!node.equals(firstNode));
  	
  	ans.reverse();
  	
    return ans.toString();
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    ShortestPath c = new ShortestPath();
    System.out.print(c.path(s.nextLine())); 
  }   
  
}


/*
 * 
4,A,B,C,D,A-B,B-D,B-C,C-D

7,A,B,C,D,E,F,G,A-B,A-E,B-C,C-D,D-F,E-D,F-G

5,A,B,C,D,F,A-B,A-C,B-C,C-D,D-F

4,X,Y,Z,W,X-Y,Y-Z,X-W

6,Z,B,C,A,Y,Q,B-C,A-B,A-Z,C-Y,Z-Y,C-Q

 * */




  