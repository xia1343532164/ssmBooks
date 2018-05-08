package Books.controller;

public class BookSearch {

	private String bookname;
	
	private String author;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		if(!bookname.trim().isEmpty()){
			this.bookname = bookname;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(!author.trim().isEmpty()){
			this.author = author;
		}
	}

	@Override
	public String toString() {
		return "BookSearch [bookname=" + bookname + ", author=" + author + "]";
	}

}
