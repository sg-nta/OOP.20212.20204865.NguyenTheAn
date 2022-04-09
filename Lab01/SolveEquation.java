import javax.swing.Icon;  
import javax.swing.JOptionPane;  
import javax.swing.UIManager;  
import javax.swing.JTextField;
import java.lang.Math;
public class SolveEquation{
    public static void main(String[] args){
        
        Icon errorIcon = UIManager.getIcon("OptionPane.informationIcon");  
        Object[] possibilities = {"Linear Equation","Second Order Equation","System of linear equation"};  
        /*
        Integer i = (Integer) JOptionPane.showOptionDialog(null,   
                null,  "ShowInputDialog",   
                JOptionPane.PLAIN_MESSAGE, 1,  errorIcon, possibilities, 0);
        */
        // or

        String choice = (String) JOptionPane.showInputDialog(null,  
                "Select which kind of equation you want to solve", "ShowInputDialog",  
                JOptionPane.PLAIN_MESSAGE, errorIcon, possibilities, "Numbers");  
        if (choice == "Linear Equation"){
            String strNum1 = JOptionPane.showInputDialog(null,
            "Please input a: (a can't be 0)","Linear Equation ax + b = 0",
            JOptionPane.INFORMATION_MESSAGE);

            String strNum2 = JOptionPane.showInputDialog(null,
            "Please input b: ","Linear Equation ax + b = 0",
            JOptionPane.INFORMATION_MESSAGE);

            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            if (num1 != 0){
                JOptionPane.showMessageDialog(null,"Solution: x = " + (-num2/num1),"Linear equation ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"The parameter a can't be 0","Linear equation ax + b = 0",JOptionPane.ERROR_MESSAGE);
            }
        }    
        else if (choice == "Second Order Equation"){
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();
            Object[] message = {
                "Input value a:", field1,
                "Input value b:", field2,
                "Input value c:", field3,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Second order equation ax^2 + bx + c = 0", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                String value1 = field1.getText();
                String value2 = field2.getText();
                String value3 = field3.getText();
                double a = Double.parseDouble(value1);
                double b = Double.parseDouble(value2);
                double c = Double.parseDouble(value3);
                
                double delta = b*b - 4*a*c;
                if (a != 0){
                    if (delta == 0){
                    JOptionPane.showMessageDialog(null,"Double root: x = " + (-b/2*a),"Second order equation ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (delta < 0){
                        JOptionPane.showMessageDialog(null,"The equation has no root","Second order equation ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (delta > 0){
                        JOptionPane.showMessageDialog(null,"The equation has two distinct roots:"+ "\n" + " x_1 = " + ((-b+Math.sqrt(delta))/2*a)
                        + "\n" +  " x_2 = " + ((-b-Math.sqrt(delta))/2*a),"Second order equation ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                else{
                    JOptionPane.showMessageDialog(null,"The parameter a can't be 0","Second order equation ax^2 + bx + c = 0",JOptionPane.ERROR_MESSAGE);
                }
                }
                
        }
        else {
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();
            JTextField field4 = new JTextField();
            JTextField field5 = new JTextField();
            JTextField field6 = new JTextField();
            Object[] message = {
                "Input value a_1:", field1,
                "Input value b_1:", field2,
                "Input value c_1:", field3,
                "Input value a_2:", field4,
                "Input value b_2:", field5,
                "Input value c_2:", field6,

            };
            int option = JOptionPane.showConfirmDialog(null, message, "System of linear equation:\n" + "a_1x + b_1y = c_1 \n" + "a_2x + b_2y = c_2", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                String value1 = field1.getText();
                String value2 = field2.getText();
                String value3 = field3.getText();
                String value4 = field4.getText();
                String value5 = field5.getText();
                String value6 = field6.getText();
                double a1 = Double.parseDouble(value1);
                double b1 = Double.parseDouble(value2);
                double c1 = Double.parseDouble(value3);
                double a2 = Double.parseDouble(value4);
                double b2 = Double.parseDouble(value5);
                double c2 = Double.parseDouble(value6);
                double det1 = a1*b2 - a2*b1;
                double det2 = c1*b2 - c2*b1;
                double det3 = a1*c2 - a2*c1;
                if (det1!=0){
                    JOptionPane.showMessageDialog(null,"This system has unique solution: \nx = " + det2/det1 + "\ny = " + det3/det1,"Result",JOptionPane.INFORMATION_MESSAGE);
                }
                else if 9(a2 == 0 && b2 == 0 && c2 != 0) || (a1 == 0 && b1 == 0 && c1 != 0)){
                    JOptionPane.showMessageDialog(null,"This system has no solution","Result",JOptionPane.INFORMATION_MESSAGE);
                }
                else if (a1/a2 == b1/b2 && a1/a2 != c1/c2){
                    JOptionPane.showMessageDialog(null,"This system has no solution","Result",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"This system has infinite solutions","Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
    }
}