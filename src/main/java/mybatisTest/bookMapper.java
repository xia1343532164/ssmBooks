package mybatisTest;

import java.util.List;

import Books.entity.Book;


//��һ������дmapper�ӿڣ���Ҫʲô���ݲ���

public interface bookMapper {
	List<Book> findAll();

}
