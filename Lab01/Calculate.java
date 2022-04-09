import javax.swing.JOptionPane;
public class Calculate{
    public static void main(String[] args){
        String strNum1,strNum2;

        strNum1 = JOptionPane.showInputDialog(null,"Input the first number: ","Input the first number: ",
        JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,"Input the second number: ","Input the second number: ",
        JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null,"Sum: Num1 + Num2 = " + num1 + " + " + num2 + " = " + (num1 + num2) + "\n" +
         "Difference: Num1 - Num2 = " + num1 + " - " + num2 + " = " + (num1 - num2) + "\n" +
         "Product: Num1 * Num2 = " + num1 + " * " + num2 + " = " + (num1 * num2) + "\n" +
         "Quotient: Num1 : Num2 = " + num1 + " : " + num2 + " = " + (num1 / num2),"Result",JOptionPane.INFORMATION_MESSAGE );
    }
}