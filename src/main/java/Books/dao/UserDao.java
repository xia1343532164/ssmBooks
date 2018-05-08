package Books.dao;

import Books.entity.User;

public interface UserDao {

	User findOneByUsername(String username);
}
