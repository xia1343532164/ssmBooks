package Books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import Books.entity.BookTest;
import Books.entity.User;
import Books.service.BookTestService;

@Controller
public class BookTestController {
	private BookTestService bookService;
	
	@Autowired
	public BookTestController(BookTestService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books-crud")
	public String crudGrid(@AuthenticationPrincipal(expression = "user") User user) {
	// @AuthenticationPrincipalĬ���õ�����principal(UserDetailsImpl)��������Ҫ.user���ʵ��User����
		System.out.println("��ǰ��¼�û�Ϊ:"+user);
		return "books-crud";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/")
	@ResponseBody // �ѷ���ֵͨ��ĳ�ָ�ʽ(json��xml)ת���ı���Ϊ��Ӧ
	public List<BookTest> findAll() {
	/*	List<BookTest> books = ne+ ArrayList<>();
		BookTest book1 = new BookTest();
		book1.setId(1);
		book1.setAuthor("�ι��");
		book1.setTitle("�����ӵ���������");
		book1.setPublisher("Java7��");
		
		books.add(book1);
		
		return books;*/
		return bookService.findAll();
	}
	@RequestMapping(method = RequestMethod.POST,value = "/books/")
	@ResponseBody
    public BookTest creat(@RequestBody BookTest book){
		bookService.creat(book);
		return book;
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/books/{id}")
	@ResponseBody
	public BookTest update(@PathVariable Integer id,@RequestBody BookTest book){
		book.setId(id);
		bookService.update(book);
		return book;
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/books/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id){
		bookService.delete(id);
	}
}
