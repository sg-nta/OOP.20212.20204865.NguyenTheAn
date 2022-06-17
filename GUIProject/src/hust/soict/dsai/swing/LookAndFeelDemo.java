package hust.soict.dsai.swing;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelDemo extends JFrame{
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	private void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	private void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel ("Change Look and Feel Here: "));
		
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length];
		for (int i = 0; i < lafInfos.length; i++) {
			if (lafInfos[i].getName() == "Metal") {
				lafNames[i] = "Java";
			}
			else if (lafInfos[i].getName() == "Windows") {
				lafNames[i] = "System";
			}
			else {
				lafNames[i] = lafInfos[i].getName();	
			}
		}
		
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafInfos[index].getClassName());

				}catch(Exception e) {
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);

				setTitle(lafNames[index] + " Look And Feel");
				
			}
			
		});
	}
}
