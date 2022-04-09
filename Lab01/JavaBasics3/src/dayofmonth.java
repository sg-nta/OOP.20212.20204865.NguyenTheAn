import javax.swing.JOptionPane;
public class dayofmonth {
    public static void main(String[] args){
        int month = 0,year = 0,k=0;
        
        while (month <1 || month >12){
            String strmonth = JOptionPane.showInputDialog(null,"Input the month (The value of month is between 1 and 12 (January and December)) ",
            "Input the month:",JOptionPane.INFORMATION_MESSAGE);
            if ((strmonth.equals("January")) || (strmonth.equals("Jan.")) ||(strmonth.equals("Jan")) || (strmonth.equals("1"))){
				month = 1;
			}
			else if (strmonth.equals("February") || strmonth.equals("Feb.") ||strmonth.equals("Feb") || strmonth.equals("2")){
				month = 2;
			}
			else if (strmonth.equals("March") || strmonth.equals("Mar.") ||strmonth.equals("Mar") || strmonth.equals("3")){
				month = 3;
			}
			else if (strmonth.equals("April") || strmonth.equals("Apr.") ||strmonth.equals("Apr") || strmonth.equals("4")){
				month = 4;
			}
			else if (strmonth.equals("May") ||  strmonth.equals("5")){
				month = 5;
			}
			else if (strmonth.equals("June") || strmonth.equals("Jun") || strmonth.equals("6")){
				month = 6;
			}
			else if (strmonth.equals("July") || strmonth.equals("Jul") || strmonth.equals("7")){
				month = 7;
			}
			else if (strmonth.equals("August") || strmonth.equals("Aug.") ||strmonth.equals("Aug") || strmonth.equals("8")){
				month = 8;
			}
			else if (strmonth.equals("September") || strmonth.equals("Sept.") ||strmonth.equals("Sep") || strmonth.equals("9")){
				month = 9;
			}
			else if (strmonth.equals("October") || strmonth.equals("Oct.") ||strmonth.equals("Oct") || strmonth.equals("10")){
				month = 10;
			}
			else if (strmonth.equals("November") || strmonth.equals("Nov.") ||strmonth.equals("Nov") || strmonth.equals("11")){
				month = 11;
			}
			else if (strmonth.equals("December") || strmonth.equals("Dec.") ||strmonth.equals("Dec") || strmonth.equals("12")){
				month = 12;
			}
            
        }
        while (k==0){
            try{
                year = Integer.parseInt(JOptionPane.showInputDialog(null,"Input the year (Year is an integer number) ",
                "Input the year:",JOptionPane.INFORMATION_MESSAGE));
                k=1;
            }
            catch  (NumberFormatException ex)
            {
                k=0;
            }
        }

        JOptionPane.showMessageDialog(null,"You've entered: Month = " + month +
        "\n Year = " +year ,"result",JOptionPane.INFORMATION_MESSAGE);
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			JOptionPane.showMessageDialog(null,"This month has: 31 days" ,"result",JOptionPane.INFORMATION_MESSAGE);
		}
        if (month == 4 || month == 6 || month == 9 || month == 11){
			JOptionPane.showMessageDialog(null,"This month has: 30 days" ,"result",JOptionPane.INFORMATION_MESSAGE);
		}
        if (month == 2)
        {
            if ((year%4!=0) ||((year % 100 == 0) && (year %400 != 0))) {
                JOptionPane.showMessageDialog(null,"This month has: 28 days" ,"result",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"This month has: 29 days" ,"result",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

