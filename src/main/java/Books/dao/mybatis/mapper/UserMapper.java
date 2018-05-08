package Books.dao.mybatis.mapper;

import Books.entity.User;

public interface UserMapper {

	User findOneByUsername(String username);

}
