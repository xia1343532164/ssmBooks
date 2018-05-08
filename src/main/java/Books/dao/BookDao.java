package Books.dao;

import java.util.List;

import Books.controller.BookSearch;
import Books.entity.Book;

public interface BookDao {

	List<Book> findAll(int page, int limit);

	void add(Book book);

	Book findOne(int id);

	void editUpdate(Book book);

	void delete(int id);

	void batchDelete(List<Integer> idList);

	int count();

	List<Book> search(BookSearch bookSearch);



}
