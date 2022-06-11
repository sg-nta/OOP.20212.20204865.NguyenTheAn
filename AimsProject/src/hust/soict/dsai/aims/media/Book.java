package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String,Integer> wordFrequency = new HashMap<String,Integer>();
	public Book(List<String> authors) {
		// TODO Auto-generated constructor stub
		this.authors = authors;
	}
	private List<String> getAuthors() {
		return authors;
	}
	private void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		int check = 0;
		for (int i = 0; i < authors.size(); i++ ) {
			if (authors.get(i).equals(authorName)) {
				System.out.println("This author is already in the list");
				check += 1;
			}
		}
		if (check == 0) {
			authors.add(authorName);
			System.out.println("This author's name has been added");
		}
	}
	public void removeAuthor(String authorName) {
		int index = -1;
		for (int i = 0; i < authors.size(); i ++) {
			if (authors.get(i).equals(authorName)) {
				index = i;
			}
		}
		if (index == -1) {
			System.out.println("This author's name is not in the list");
		}
		else {
			authors.remove(index);
			System.out.println("This author's name has been removed");
		}
	}
	public String toString() {
		String result = "Book - " + super.toString() + " - Author: " + this.getAuthors() + " - Length: " + this.contentTokens.size() + "\nToken list: ";
		for (String key : this.contentTokens) {
			result += key += ", ";
		}
		result += "\nWord Frequency" ;
		result += this.wordFrequency.toString();
		return result;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getContentTokens() {
		return contentTokens;
	}
	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}
	public void processContent() {
		List<String> splittedContent = Arrays.asList(content.split("[: ;.,?!]"));
		Integer ONE = new Integer(1);
		for (int i = 0; i < splittedContent.size(); i ++ ) {
			String key = splittedContent.get(i).toLowerCase();
			this.contentTokens.add(key);
			Integer frequency = this.wordFrequency.get(key);
			if (frequency == null) {
				frequency = ONE;
			}
			else {
				int value = frequency.intValue();
				frequency = new Integer(value +1);
			}
			this.wordFrequency.put(key, frequency);
		}
		Map sortedMap = new TreeMap(this.wordFrequency);
		Collections.sort(contentTokens);
		this.wordFrequency = sortedMap;
	}
	

}
