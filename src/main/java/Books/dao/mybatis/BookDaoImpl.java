package Books.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import Books.controller.BookSearch;
import Books.dao.BookDao;
import Books.entity.Book;

@Repository
@Primary
public class BookDaoImpl implements BookDao {

	private Books.dao.mybatis.mapper.bookMapper bookMapper;
	
	@Autowired
	public BookDaoImpl(Books.dao.mybatis.mapper.bookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public List<Book> findAll(int page, int limit) {
		return bookMapper.findAll( (page - 1) * limit,page*limit);
	}

	@Override
	public void add(Book book) {
		System.out.println(book);
          bookMapper.add(book);
	}

	@Override
	public Book findOne(int id) {
		return bookMapper.findOne(id);
	}

	@Override
	public void editUpdate(Book book) {
              bookMapper.editUpdate(book);
	}

	@Override
	public void delete(int id) {
              bookMapper.delete(id);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
	/*	StringJoiner sj = new StringJoiner(",", "(", ")");
		for(Integer i : idList){
			sj.add(i.toString());
		}
		String list = sj.toString();*/
		bookMapper.batchDelete(idList);
	}

	@Override
	public int count() {
		return bookMapper.count();
	}


	@Override
	public List<Book> search(BookSearch bookSearch) {
		return bookMapper.search(bookSearch);
	}

}
