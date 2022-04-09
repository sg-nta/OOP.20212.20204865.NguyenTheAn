import java.util.Scanner;
public class triangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input the value of n: ");
		int n = keyboard.nextInt();
		for (int i = 1;i<n+1;i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(" ");
			}
			for (int j = n-i; j < n+i-1; j++) {
				System.out.print("*");
			}
			for (int j = n+i-1; j < 2*n-1; j++) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
