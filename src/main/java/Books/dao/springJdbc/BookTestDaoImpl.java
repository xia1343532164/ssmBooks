package Books.dao.springJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import Books.dao.BookTestDao;
import Books.entity.BookTest;
import Books.service.BookTestService;
@Repository
public class BookTestDaoImpl  implements BookTestDao{

	private JdbcTemplate template;
	
	@Autowired
	public BookTestDaoImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<BookTest> findAll() {
		String sql = " select id,title,author,publisher from booktest";
		return template.query(sql, new BookTestmapper());
	}

	class BookTestmapper implements RowMapper<BookTest>{

		@Override
		public BookTest mapRow(ResultSet rs, int arg1) throws SQLException {
			BookTest bt = new BookTest();
			bt.setId(rs.getInt(1));
			bt.setTitle(rs.getString(2));
			bt.setAuthor(rs.getString(3));
			bt.setPublisher(rs.getString(4));
			return bt;
		}
		
	}

	@Override
	public void create(BookTest book) {
        	String sql  =  "insert into bookTest(id, title,author,publisher) values(booktest_seq.nextval,?,?,?)";	
        	KeyHolder keyHolder = new GeneratedKeyHolder();
        	template.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
					ps.setString(1, book.getTitle());
					ps.setString(2, book.getAuthor());
					ps.setString(3, book.getPublisher());
					return ps;
				}
			},
			keyHolder);
		book.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void update(BookTest book) {
             String sql  = "update bookTest set title=?,author=?,publisher=? where id=? ";	
             template.update(sql, book.getTitle(),book.getAuthor(),book.getPublisher(),book.getId());
	}

	@Override
	public void delete(Integer id) {
           String sql = "delete from booktest where id  = ?";
           template.update(sql, id);
	}
	}
