package testCode;

public class ReverseStr {
	public void revStr() {
		//System.out.println("Hello");
		char[] input = { 'h', 'e', 'l', 'l', 'o','r' };
		int i=0;
		int j=input.length-1;
		while (i<j) {
			char val1= input[i];
			char val2= input[j];
			input[i]=val2;
			input[j]=val1;
			i++;j--;
		}
			for(char s: input) {
				System.out.println(s);
			}
		}
}

