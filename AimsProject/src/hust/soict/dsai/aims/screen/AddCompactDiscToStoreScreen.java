package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame{
	private Store store;

	private JTextField title;
	private JTextField category;
	private JTextField director;
	private JTextField length;
	private JTextField cost;
	private JTextField artist;
	private JButton btnSubmit;
	private JButton btnBack;

	public AddCompactDiscToStoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(7,7));
		
		cp.add(new JLabel("Enter title"));
		title = new JTextField(20);
		cp.add(title);
		
		cp.add(new JLabel("Enter category"));
		category = new JTextField(20);
		cp.add(category);
		
		cp.add(new JLabel("Enter director"));
		director = new JTextField(20);
		cp.add(director);
		
		cp.add(new JLabel("Enter length"));
		length = new JTextField(20);
		cp.add(length);
		
		cp.add(new JLabel("Enter cost"));
		cost = new JTextField(20);
		cp.add(cost);
		
		cp.add(new JLabel("Enter artist"));
		artist = new JTextField(20);
		cp.add(artist);
		

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreManagerScreen(store);
				dispose();
				
			}
			
		});
		btnSubmit = new JButton("Enter");
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titleString = title.getText();
				String categoryString = category.getText();
				String directorString = director.getText();
				String artistString = artist.getText();
				int lengthInt = Integer.parseInt(length.getText());
				float costFloat = Float.parseFloat(cost.getText());
				CompactDisc cd = new CompactDisc(titleString, categoryString, costFloat, lengthInt, directorString, artistString);
				store.addMedia(cd);
				new StoreManagerScreen(store);
				dispose();
			}
			
		});
		cp.add(btnBack);
		cp.add(btnSubmit);

		setTitle("Add DVD");
		setSize(600,240);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
