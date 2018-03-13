package org.prem.example;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bhavesh.Thaker
 */
@XmlRootElement(name = "book")
public class Book {

	private int id;

	private String bookName;

	private String bookAuthor;

	private String bookISBN;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

}