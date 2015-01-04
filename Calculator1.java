package coderbyte;

import java.util.*; 
import java.io.*;

public class Calculator1 {

	Stack<Integer> num = new Stack<Integer>();
	Stack<Character> op = new Stack<Character>();
	StringBuilder s = new StringBuilder();

	String Calculator(String str) {

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (Character.isDigit(c))
				if(i == str.length()-1)
				{
					s.append(c);
					num.push(Integer.parseInt(s.toString()));
				}
				else
					s.append(c);

			else {
				if(s.length() > 0)
					num.push(Integer.parseInt(s.toString()));
				s = new StringBuilder("");
				
				if (c == ')') {
					while (op.peek() != '(')
						eval();
					op.pop();
					if (i < str.length() - 1
							&& (str.charAt(i + 1) == '(' || Character
									.isDigit(str.charAt(i + 1))))
						op.push('*');
				}

				else if (op.size() > 0 && hasLowEqPrec(c, op.peek())) {
					while(op.size() > 0 && hasLowEqPrec(c, op.peek()))
						eval();
					op.push(c);
				} else
					if( c == '(' &&  i>0 && Character
							.isDigit(str.charAt(i - 1)))
							{
								op.push('*');
								op.push(c);
							}
					else
					op.push(c);
			}
		}

		while (op.size() != 0) {
			eval();
		}

		int finalAns = num.pop();

		return String.valueOf(finalAns);

	}

	private boolean hasLowEqPrec(char c, char peek) {

		if (c == '+' || c == '-')
			if (peek == '*' || peek == '/' || peek == '+' || peek == '-')
				return true;
			else
				return false;
		else
			if(c == '*' || c == '/')
				if (peek == '*' || peek == '/')
			return true;
				else
					return false;
		
		return false;
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
		Calculator1 c = new Calculator1();
		//System.out.print(c.Calculator("2+(3-1)*3"));
		//System.out.print(c.Calculator("7-2+(5-2)"));
		//System.out.print(c.Calculator("30*20"));
		System.out.print(c.Calculator("7-4-1+8(3)/2"));
		
	}

}








  