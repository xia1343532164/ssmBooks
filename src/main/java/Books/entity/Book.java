package Books.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Book {

	private Integer id;
	@Size(min=1,max=128,message="1~128����")
	private String bookname;
	
	@Size(min=2,max=24,message="2~24����")
	private String author;//����
	
	@Size(min=2,max=64,message="2~64����")
	private String press;//������
	
	@NotNull(message="����")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date year;//�������
	
	@Size(min=10,max=2048,message="10~2048����")
	private String synopsis;//���
	
	@Size(min=2,max=24,message="2~24����")
	private String category;//���
	//�ļ��ϴ������ʵ����
	private MultipartFile picture;
	
	private String picturePath;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", press=" + press + ", year="
				+ year + ", synopsis=" + synopsis + ", category=" + category + ", picturePath=" + picturePath + "]";
	}
    

	
}
