package coderbyte;

import java.util.*; 
import java.io.*;

public class RevPolish {

	Stack<Integer> num = new Stack<Integer>();
	Stack<Character> op = new Stack<Character>();

	String Calculator(String str) {
		
		String sp[] = str.split(" ");
		
		for (int i = 0; i < sp.length; i++) {
			
			String st = sp[i];
			
			if (st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/"))
			{
				op.push(st.charAt(0));
				eval();
			}
			
			else
			{
				num.push(Integer.parseInt(st));
			}
		}

		while (op.size() != 0) {
			eval();
		}

		int finalAns = num.pop();

		return String.valueOf(finalAns);

	}

	void eval() {
		int n1 = num.pop();
		int n2 = num.pop();
		int ans = 0;

		char c = op.pop();

		switch (c) {
		case '+':
			ans = n2 + n1;
			break;
		case '-':
			ans = n2 - n1;
			break;
		case '*':
			ans = n2 * n1;
			break;
		case '/':
			ans = n2 / n1;
			break;
		}

		num.push(ans);

	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		RevPolish c = new RevPolish();
		//System.out.print(c.Calculator("2+(3-1)*3"));
		//System.out.print(c.Calculator("7-2+(5-2)"));
		System.out.print(c.Calculator("2 12 + 7 /"));
		//System.out.print(c.Calculator("4 5 + 2 1 + *"));
		
	}

}








  