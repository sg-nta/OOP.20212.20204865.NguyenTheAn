import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class AddMatrix {
    
    String MatrixString(int[][] matrix,int n,int m){
        String output = "";
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                output += matrix[i][j] + " ";
                
            }
            output += "\n";
        }
    return output;

    }
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
        AddMatrix ob = new AddMatrix();

        System.out.print(Arrays.toString(array1));
        JOptionPane.showMessageDialog(null,"Input matrix 1: \n" + ob.MatrixString(array1,n,m) + "\nInput matrix 2: \n" + ob.MatrixString(array2,n,m),"Information",JOptionPane.INFORMATION_MESSAGE);
        int [][] sum = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                sum[i][j] = array1[i][j] + array2[i][j];
            }
        }
        JOptionPane.showMessageDialog(null,"Sum of two matrices: \n" + ob.MatrixString(sum,n,m),"Information",JOptionPane.INFORMATION_MESSAGE);

    }
}