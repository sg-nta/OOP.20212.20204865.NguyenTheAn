package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class LoginScreen extends JFrame{
	private Store store;
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Li King",
				"Animation","Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wa",
				"Science Fiction","George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Ala",
				"Animation", 18.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion Ki",
				"Animation","Roger Allers", 87, 19.95f);
		CompactDisc cd = new CompactDisc("Chay ngay di", "Pop",3.5f, 3, "Ko biet", "Moutain");
		List<String> authors = new ArrayList<String>();
		authors.add("Adam");
		authors.add("Eve");
		Book book = new Book("Bible","Education",20.5f,authors);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd6);
		store.addMedia(dvd7);
		store.addMedia(cd);
		store.addMedia(book);

		new LoginScreen(store);
	}
	public LoginScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		
		JRadioButton customerBtn = new JRadioButton("Customer");
		JRadioButton managerBtn = new JRadioButton("Store Manager");
		customerBtn.setBounds(140, 40, 120, 30);
		managerBtn.setBounds(140, 90, 120, 30);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(customerBtn);
		bg.add(managerBtn);
		customerBtn.setSelected(true);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(140, 140, 120, 30);
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerBtn.isSelected()) {
					new StoreManagerScreen(store);
					dispose();
				}
				
			}
			
		});
		cp.add(customerBtn);
		cp.add(managerBtn);
		cp.add(loginBtn);
		
		setTitle("Login");
		setSize(400, 250);
		
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
