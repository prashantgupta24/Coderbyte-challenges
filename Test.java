package coderbyte;

import java.util.*; 
import java.io.*;

public class Test {  
  String WeightedPath(String[] strArr) { 
  
int numberOfNodes=Integer.valueOf(strArr[0]);
	Map<String,Node> nodeMap=new HashMap<String,Node>();	
	
	//parse nodes
	for(int i=1;i<=numberOfNodes;i++)
		nodeMap.put(strArr[i], new Node(strArr[i],Integer.MAX_VALUE));
	
	//parse edges	
	for(int i=numberOfNodes+1;i<strArr.length;i++)
	{
		Node n1 =nodeMap.get(strArr[i].split("\\|")[0]);
		Node n2 =nodeMap.get(strArr[i].split("\\|")[1]);
		int cost = Integer.valueOf(strArr[i].split("\\|")[2]);
		Edge e = new Edge(cost,n1,n2);
	}
	//set start & goal
	Node start=nodeMap.get(strArr[1]);
	Node goal=nodeMap.get(strArr[numberOfNodes]);
		
	return getPathToGoal(start,goal);    
    
  }      
public String getPathToGoal(Node start, Node goal){
	  start.setPath(start.key);
	  start.setValue(0);
	  PriorityQueue<Node> expand=new PriorityQueue<Node>();
	  expand.add(start);
	  
	  while(!expand.isEmpty()){
		  Node current=expand.poll();
		  if(current==goal)
			  return current.getPath();
		  
		  for(Edge e : current.getEdges())
		  {
			  Node tmp=e.getOther(current);
			  if(tmp.getValue()>current.getValue()+e.getCost())
			  {
				  if(expand.contains(tmp))
					  expand.remove(tmp);
				  tmp.setValue(current.getValue()+e.getCost());
				  tmp.setPath(current.getPath()+"-"+tmp.getKey());
				  expand.add(tmp);
			  }
		  }		  
	  }	  
	  //no way
	  return "-1";
	  
  }
  
class Node implements Comparable<Node>{
    private String key;
    private int value;    
    private String path;
    private List<Edge> edges;
    
    public Node(String key, int value){
    this.key=key;
    this.value=value;
    edges=new ArrayList<Edge>();
    this.path="";
    }
    
    public int compareTo(Node other){
    	Integer a=this.value;
    	Integer b= other.value;    	
    	return a.compareTo(b);
    }
    public String getPath(){return this.path;}
    public void setPath(String s){this.path=s;}
    public int getValue(){ 	return this.value; }
    public void setValue(int value){ this.value=value;}
    public String getKey(){ 	return this.key; }
    public void addEdge(Edge e){edges.add(e);}
    public List<Edge> getEdges(){return edges;}
    public String toString(){return this.key.toString();}
    
  }

class Edge{
	private int cost;
	private Node n1;
	private Node n2;
	
	public Edge(int cost, Node n1, Node n2){
		this.cost=cost;
		this.n1=n1;
		this.n2=n2;
		n1.addEdge(this);
		n2.addEdge(this);
	}
	
	public Node getOther(Node n){return (n==n1)? n2 : n1;}
	public int getCost(){return this.cost;}
}
  
public static void main (String[] args) {  
	   
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Test c = new Test();
    //System.out.print(c.WeightedPath(new String[]{"6","A","B","C","D","E","F","B|A|2","A|F|12","A|C|4","B|D|1","D|E|1","C|D|4","F|E|1"}));
    //System.out.print(c.WeightedPath(new String[]{"3","AA","BB","CC","CC|BB|102"}));
    
  }
  
}


         
