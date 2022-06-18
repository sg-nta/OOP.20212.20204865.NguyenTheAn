package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame{
	private Store store;
	private JTextField title;
	private JTextField category;
	private JTextField content;
	private JTextField cost;
	private JTextField authors;
	private JButton btnSubmit;

	public AddBookToStoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(6,6));
		
		cp.add(new JLabel("Enter title"));
		title = new JTextField(20);
		cp.add(title);
		
		cp.add(new JLabel("Enter authors ( separated by space )"));
		authors = new JTextField(20);
		cp.add(authors);
		
		cp.add(new JLabel("Enter category"));
		category = new JTextField(20);
		cp.add(category);
		
		cp.add(new JLabel("Enter content"));
		content = new JTextField(20);
		cp.add(content);
		
		cp.add(new JLabel("Enter cost"));
		cost = new JTextField(20);
		cp.add(cost);
		
		btnSubmit = new JButton("Enter");
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titleString = title.getText();
				String categoryString = category.getText();
				String contentString = content.getText();
				float costFloat = Float.parseFloat(cost.getText());
				List<String> authorsList = new ArrayList<String>();
				String [] authorsArray = authors.getText().split(" ");
				for (String author: authorsArray) {
					authorsList.add(author);
				}
				Book book = new Book(titleString, categoryString, costFloat, authorsList);
				book.setContent(contentString);
				book.processContent();
				store.addMedia(book);
				new StoreManagerScreen(store);
				dispose();
			}
			
		});

		cp.add(btnSubmit);

		setTitle("Add DVD");
		setSize(600,240);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}

