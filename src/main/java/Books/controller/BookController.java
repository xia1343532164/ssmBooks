package Books.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import Books.entity.Book;
import Books.service.BookService;
@Controller
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BookService bookService;
	
	private String uploadDir = "E:/upload";//�����ļ��ϴ�·��
     
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/admin/book")
	public String finaAll(Model model, @RequestParam(required = false,defaultValue = "1")int page){
		
		System.out.println("����: GET /customers, page=" + page);
		
		int limit = 5;//ÿҳ����
		List<Book> books = bookService.findAll(page,limit);
		int count = bookService.count();
		int pageCount =(int) Math.ceil(count / (double)limit);

		model.addAttribute("books", books);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currentPage", page);
		
		return "book";
	}
	//���ͼ��չʾ
	@RequestMapping(method=RequestMethod.GET,value="/book/add")
   public String newBook(@ModelAttribute Book book){
	   //model.addAttribute("book", new Book());
		return "book-edit";
   }
	//���ͼ��
	@RequestMapping(method=RequestMethod.POST,value="/book/add")
   public String addBook(@Valid @ModelAttribute Book book,BindingResult bindingResult ){
		// ʹ��@Valid����У�飬BindingResultx���У���������������ɶԳ��֣�����Ҫ��֤�Ⱥ�˳��
	   if(bindingResult.hasErrors()){
		   //model.addAttribute("book", book);
		   return "book-edit";
	   }else{
		   bookService.add(book);
		   return "redirect:/book";
	   }
   }
	//�޸�
	@RequestMapping(method=RequestMethod.GET,value="/book/{id}/edit")
	public String edit(@PathVariable int id,Model model){
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book-edit";
	}
	@RequestMapping(method=RequestMethod.POST,value="/book/{id}/edit")
	public String editupdate(@PathVariable int id,@Valid @ModelAttribute Book book ,BindingResult bindingResult) throws Exception{
		
		System.out.println("POST �޸ģ�" + book);
		//�ļ���
		String filename = book.getPicture().getOriginalFilename();
		
		System.out.println("��Ƭ: " +filename+","+ book.getPicture().getOriginalFilename() + ", " 
							+ book.getPicture().getSize() + "�ֽ�");
		if(book.getPicture().getSize()==0 
				|| !book.getPicture().getContentType().toLowerCase().startsWith("image/"))
		{
			bindingResult.rejectValue("picture", "formError.pictureRequired", "��ѡ����Ƭ");
		}
		if(bindingResult.hasErrors()){
			return "book-edit";
		}else{
			book.setId(id);
			book.getPicture().transferTo(new File(uploadDir,filename));
			book.setPicturePath(filename);
			bookService.editUpdate(book);
			return "redirect:/book";
		}
	}
	//����
	@RequestMapping(method=RequestMethod.GET,value="/book/{id}/details")
	public String details(@PathVariable int id,Model model){
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book-details";
	}
	//ɾ��
	@RequestMapping(method=RequestMethod.POST,value="/book/{id}/delete")
	public String delete(@PathVariable int id){
		bookService.delete(id);
		return "redirect:/book";
	}
	//����ɾ��
	@RequestMapping(method=RequestMethod.POST,value="/book/batch-delete")
	public String batchDelete(@RequestParam String ids){
		List<Integer> idList = new ArrayList<>();
		for (String id : ids.split(",")) {
			idList.add(Integer.valueOf(id));
		}
		System.out.println("����ɾ����#"+idList);
		bookService.batchDelete(idList);
		return "redirect:/book";
	}
	@RequestMapping(method=RequestMethod.GET,value="/book/search")
	public String search(@RequestParam(required = false) BookSearch bookSearch,Model model){
		System.out.println("bookSearch: " + bookSearch);
		List<Book> book = bookService.search(bookSearch);
	     model.addAttribute("book", book); 
		 return "book-search";
		
	}
		
}
