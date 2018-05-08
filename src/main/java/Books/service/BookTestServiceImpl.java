package Books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Books.dao.BookTestDao;
import Books.entity.BookTest;

@Service
@Transactional
public class BookTestServiceImpl implements BookTestService {

	private BookTestDao bookDao;
	
	@Autowired
	public BookTestServiceImpl(BookTestDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<BookTest> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void creat(BookTest book) {
        bookDao.create(book);		
	}

	@Override
	public void update(BookTest book) {
           bookDao.update(book);		
	}

	@Override
	public void delete(Integer id) {
            bookDao.delete(id);		
	}

}
