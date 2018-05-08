package mybatisTest;

import java.util.List;

import Books.entity.Book;


//第一步，先写mapper接口，需要什么数据操作

public interface bookMapper {
	List<Book> findAll();

}
