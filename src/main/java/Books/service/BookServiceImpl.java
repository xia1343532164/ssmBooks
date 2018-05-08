package Books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Books.controller.BookSearch;
import Books.dao.BookDao;
import Books.entity.Book;
@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findAll(int page,int limit) {
		return bookDao.findAll(page,limit);
		 
	}

	@Override
	public void add(Book book) {
		 bookDao.add(book);
	}

	@Override
	public Book findOne(int id) {
		return bookDao.findOne(id);
	}

	@Override
	public void editUpdate(Book book) {
         bookDao.editUpdate(book);		
	}

	@Override
	public void delete(int id) {

		bookDao.delete(id);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
            bookDao.batchDelete(idList);		
	}

	@Override
	public int count() {
		return bookDao.count();
	}

	@Override
	public List<Book> search(BookSearch bookSearch) {
		return bookDao.search(bookSearch);
	}



}
