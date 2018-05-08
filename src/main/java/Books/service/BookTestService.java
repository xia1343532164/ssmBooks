package Books.service;

import java.util.List;

import Books.entity.BookTest;

public interface BookTestService {

	List<BookTest> findAll();

	void creat(BookTest book);

	void update(BookTest book);

	void delete(Integer id);

}
