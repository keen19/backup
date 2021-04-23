package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @author keen1
 */
@Mapper
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);

    long reg(User user);

    int updateUserEmail(@Param("email") String email,@Param("id") Long id);

    List<User> getUserByNickname(@Param("nickname") String nickname);

    //获取用户信息
    User getUserById(@Param("id") Long id);

    List<Role> getAllRole();

    //修改用户enabled
    int updateUserEnabled(@Param("enabled") boolean enabled, @Param("uid") Long uid);

    int deleteUserById(Long id);

    int deleteUserRolesByUid(Long id);

    //批量插入用户角色
    int setUserRoles(@Param("rids") Long[] rids,@Param("id") Long id);

}
