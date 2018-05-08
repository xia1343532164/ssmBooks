package Books.dao;

import java.util.List;

import Books.entity.BookTest;

public interface BookTestDao {

	 List<BookTest> findAll() ;

	 void create(BookTest book);

	 void update(BookTest book);

	void delete(Integer id);

}
