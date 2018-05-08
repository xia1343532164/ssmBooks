package Books.dao.springJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import Books.controller.BookSearch;
import Books.dao.BookDao;
import Books.entity.Book;

@Repository("bookDaoSpringJdbcImpl") //// 使用指定id避免id冲突，而不是默认id（类名首字母小写）

public class BookDaoImpl implements BookDao {

	private JdbcTemplate template;
	
	@Autowired
	public BookDaoImpl(JdbcTemplate template) {
		this.template = template;
	}

class BookRowMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int num) throws SQLException {
			Book b = new Book();
			b.setId(rs.getInt(1));
			b.setBookname(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPress(rs.getString(4));
			b.setYear(rs.getDate(5));
			b.setSynopsis(rs.getString(6));
			b.setCategory(rs.getString(7));
			b.setPicturePath(rs.getString(8));
			return b;
		}
		
	}

	@Override
	public List<Book> findAll(int page,int limit) {
		String sql = "select id,bookName,author,press,Year,synopsis,category,picturePath from "
				+ "(select (rownum - 1) i ,b2.* from( "
				+ "select b.* from books b order by id"
				+ ") b2"
				+ ") b3 where i >= ? and i < ?";
		int offset = (page-1)*limit;
		List<Book> All = template.query(sql, new BookRowMapper(),offset,offset+limit);
		System.out.println(page+","+limit+","+offset);
		System.out.println(All);
		return All;
	}

	@Override
	public void add(Book book) {
		String sql = "insert into books(id,bookname,author,press,year,synopsis,category,picturePath)values(books_seq.nextval,?,?,?,?,?,?,?) ";
		template.update(sql, book.getBookname(),book.getAuthor(),book.getPress(),book.getYear(),book.getSynopsis(),book.getCategory(),book.getPicturePath());
	}

	
	@Override
	public Book findOne(int id) {
		String sql ="select id,bookname,author,press,year,synopsis,category,picturePath from books where id =?";
		Book book = template.queryForObject(sql, new BookRowMapper(),id);
		return book;
	}

	@Override
	public void editUpdate(Book book) {
             String sql = "update books set bookname=?,author=?,press=?,year=?,synopsis=?,category=? ,picturePath = ? where id = ? ";		
	         template.update(sql, book.getBookname(),book.getAuthor(),book.getPress(),book.getYear(),book.getSynopsis(),book.getCategory(),book.getPicturePath(),book.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "delete books where id = ?";
		template.update(sql,id);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
      if(idList.isEmpty()){
    	  throw new RuntimeException("请选择你要删除的图书");
      }		
      StringJoiner sj = new StringJoiner(",", "delete from books where id in(", ")");
      for(Integer id:idList){
    	  sj.add("?");
      }
      String sql = sj.toString();
      template.update(sql, idList.toArray());
	}

	@Override
	public int count() {
		String sql = "select count(*) from books";
		return template.queryForObject(sql, Integer.class);
	}


	@Override
	public List<Book> search(BookSearch bookSearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
