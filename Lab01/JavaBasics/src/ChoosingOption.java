import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to the first class ticket?","Information",
				JOptionPane.YES_NO_CANCEL_OPTION);
		JOptionPane.showMessageDialog(null,"You've chosen: " +
				(option==0?"YES":option==1?"NO":"CANCEL"));
		System.exit(0);
	}
}
