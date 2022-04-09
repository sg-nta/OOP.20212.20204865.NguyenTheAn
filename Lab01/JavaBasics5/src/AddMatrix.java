import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class AddMatrix {
    
    public static void main(String[] args){
        

        String str = (String)JOptionPane.showInputDialog(null,"Input element in first matrix (Separated by comma): ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"1 2 3,4 5 6,7 8 9");
        String[] arra = str.split(",");
       
        
        int n = arra.length,m;
        String[] arra1 = arra[0].split(" ");
        m = arra1.length;
        int [][] array1 = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] arra01 = arra[i].split(" ");
            for (int j = 0;j < m; j++){
                array1[i][j] = Integer.parseInt(arra01[j]);
            }
        }
        String str2  = (String)JOptionPane.showInputDialog(null,"Input element in second matrix (Separated by comma): ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"1 2 3,4 5 6,7 8 9");
        String[] arra2 = str2.split(",");
               
        int [][] array2 = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] arra02 = arra2[i].split(" ");
            for (int j = 0;j < m; j++){
                array2[i][j] = Integer.parseInt(arra02[j]);
            }
        }

        System.out.print(Arrays.toString(array1));
        JOptionPane.showMessageDialog(null,"Input matrix 1: " + Arrays.deepToString(array1) + "\nInput matrix 2: " +Arrays.deepToString(array2),"Information",JOptionPane.INFORMATION_MESSAGE);
        int [][] sum = new int[n][m];
        String output = "";
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                sum[i][j] = array1[i][j] + array2[i][j];
                output += sum[i][j] + " ";
                
            }
            output += "\n";
        }
        JOptionPane.showMessageDialog(null,"Sum of two matrices: \n" + output,"Information",JOptionPane.INFORMATION_MESSAGE);

    }
}