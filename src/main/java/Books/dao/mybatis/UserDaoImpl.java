package Books.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Books.dao.UserDao;
import Books.dao.mybatis.mapper.UserMapper;
import Books.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
	private UserMapper userMapper;
	
	@Override
	public User findOneByUsername(String username) {
		return userMapper.findOneByUsername(username);
	}

}
