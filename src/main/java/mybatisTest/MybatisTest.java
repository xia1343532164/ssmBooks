package mybatisTest;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Books.entity.Book;
//���Ĳ�
public class MybatisTest {
 
	public static void main(String[] args) throws Exception  {
		String resource = "mybatisTest/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		  //�򿪻Ự
		try {
			//���mapper
		  bookMapper mapper = session.getMapper(bookMapper.class);
		  //�������ݲ���
		  List<Book> book = mapper.findAll();
		  System.out.println(book);
		  
		  session.commit();
		}catch(Exception e){
			session.rollback();
			System.out.println(e);
		} finally {
		  session.close();
		}
}

}
