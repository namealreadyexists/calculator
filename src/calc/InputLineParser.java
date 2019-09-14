package calc;
import java.util.Stack;

public class InputLineParser {	
	Stack<Float> numbers;
	Stack<Character> operations;
	Float result;
	
	public InputLineParser(String s) {
		parse(s);
	}
	
	public void setResult(Float number) {
		result = number;
	}
	
	public Float getResult() {
		return result;
	}
	
	private int getOperationPriority(Character c) {
		switch(c.charValue()) {
		case '+': return 1;
		case '-': return 1;
		case '*': return 2;
		case '/': return 2;
		case 'n': return 3;
		default: return 0;
		}
	}
	
	private boolean isOperation(Character c) {
		if((c=='+')||(c=='-')||(c=='*')||(c=='/')) return true;
		else return false;
	}
	
	private void doOperation(Character op) {
		Float right_op = numbers.lastElement();numbers.pop();
		if (op == 'n') { numbers.push(right_op*(-1));}
		else {
			Float left_op = numbers.lastElement();numbers.pop();
			switch(op) {
			case '+': numbers.push(right_op+left_op);break;
			case '-': numbers.push(right_op-left_op);break;
			case '*': numbers.push(right_op*left_op);break;
			case '/': numbers.push(right_op/left_op);break;
			}
		}
	}
	
	public void parse(String s) {		
		numbers = new Stack<>();
		operations = new Stack<>();
		boolean NEGATIVE_FLAG = true; // флаг ожидания унарного минуса
		boolean OPEERATION_FLAG = false; // флаг ожидания операции 
		for(int i = 0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
			NEGATIVE_FLAG = true;
			operations.push((Character)'(');}
			else if(c==')') {
				while(((Character)operations.lastElement()).charValue()!='(') {
					doOperation(operations.lastElement());
					operations.pop();
				}
				operations.pop();
				NEGATIVE_FLAG = false;
			}
			else if(isOperation(c)) {
				char c_local = c;
				if (NEGATIVE_FLAG == true) c_local='n';
				if(OPEERATION_FLAG==true) throw new java.util.NoSuchElementException();
				if(operations.empty()!=true) {					
					while(!operations.empty()&&(getOperationPriority(operations.lastElement())>=getOperationPriority((Character)c_local))) {
						doOperation(operations.lastElement());
						operations.pop();
					}
				}
				if(NEGATIVE_FLAG!=true) {OPEERATION_FLAG =true;}
				operations.push(c_local);
				NEGATIVE_FLAG = true;
			}
			else {
				String number="";
				while(i<s.length()&(Character.isDigit(s.charAt(i))||s.charAt(i)=='.')) {
					number+=Character.toString(s.charAt(i));i++;
					if(i>=s.length())break;
					}
				i--;
				NEGATIVE_FLAG = false;
				OPEERATION_FLAG = false;
				numbers.push(Float.parseFloat(number));
			}
		}
		while(!operations.empty()) {
			doOperation(operations.lastElement());
			operations.pop();
		}
		setResult(numbers.lastElement());
	}
}
