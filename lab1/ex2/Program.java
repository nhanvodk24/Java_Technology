import vn.edu.tdtu.*;

public class Program {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7, 9 };
		int b[] = { 2, 4, 6, 8, 10 };
		ArrayOutput.print(a);
		ArrayOutput.print(b);
		int c[] = ArrayHandler.merge(a, b);
		ArrayOutput.print(c);
		ArrayHandler.sort(c);
		ArrayOutput.write(c, "Output.txt");
	}

}