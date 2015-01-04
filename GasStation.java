package coderbyte;

import java.util.*; 

public class GasStation {  
	
	  
	  class Node
	  {
		  int data;
		  Node next = null;
		  
		  Node()
		  {
			  
		  }
		  Node(int data)
		  {
			  this.data = data;
		  }
	  }
	  
	  class LList
	  {
		  Node head = null;
		  
		  LList()
		  {
			  
		  }
		  
		  void add(Node n)
		  {
			  if(head == null)
			  {
				  head = new Node(n.data);
				  head.next = head;
				  return;
			  }
			  
			  Node temp = head;
			  while(temp.next!=head)
			  {
				  temp = temp.next;
			  }
			  
			  temp.next = n;
			  n.next = head;
		  }

		public int getPos(Node n1) {
			
			int pos = 1;
			
			if(n1 == head)
			{
				return pos;
			}
			
			Node temp = head;
			while(temp.next!=head){
				
				temp = temp.next;
				pos++;				
				if(temp == n1)
					return pos;

			}
			return -1;
		}
		  
	  }
	
  private String station(String strArr) { 
  
	  ArrayList<Integer> val = new ArrayList<Integer>();
	  
	  String input[] = strArr.split(",");
	  int num = Integer.parseInt(input[0]);
	  
	  int sum = 0;
	  
	  for (int i = 0; i < num; i++) {
	
		  String vl = input[i+1];
		  String sp[] = vl.split(":");
		  
		  int v1 = Integer.parseInt(sp[0]);
		  int v2 = Integer.parseInt(sp[1]);
		  int v = v1-v2;
		  sum+=v;
		  val.add(v);
	}
	  if(sum<0)
	  {
		  System.out.println(sum);
		  return("IMPOSSIBLE!");
	  }
	  
	  LList list = new LList();
	  
	  for (int i = 0; i < val.size(); i++) {
		  Node n = new Node(val.get(i));
		  list.add(n);
	}
	  
	Node n = list.head;
	//System.out.println(n.data);

	Node n1 = n;
  while(n1.next!=n)
  {
	  Node n2 = n1;
	  int valid = 0;
	  while(n2.next !=n1)
	  {
		  valid+=n2.data;
		  if(valid<0)
			  break;
		  n2 = n2.next;
	  }
	  if(valid >=0)
		  break;
	  n1 = n1.next;
	 // System.out.println(n1.data);
  }
  
/*  System.out.println(n1.data);
  System.out.println(list.getPos(n1));*/
  
    return String.valueOf(list.getPos(n1));
    
  } 

  
 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    GasStation c = new GasStation();
    System.out.print(c.station(s.nextLine())); 
  }   
 //4,1:1,2:2,1:2,0:1
  //4,4:1,2:2,1:2,0:1
  //4,0:1,2:2,1:2,3:1
}








  