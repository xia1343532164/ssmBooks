package Books.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Books.controller.BookSearch;
import Books.entity.Book;


//��һ������дmapper�ӿڣ���Ҫʲô���ݲ���

public interface bookMapper {

	List<Book> findAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

	void add(Book book);

	Book findOne(Integer id);

	void editUpdate(Book book);

	void delete(int id);

	int count();

	void batchDelete(@Param("idList")List<Integer> idList);

	List<Book> search(BookSearch bookSearch);

}
