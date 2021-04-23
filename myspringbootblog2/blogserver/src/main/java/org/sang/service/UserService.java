package org.sang.service;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.mapper.RolesMapper;
import org.sang.mapper.UserMapper;
import org.sang.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService implements UserDetailsService {

    UserMapper userMapper;
    RolesMapper rolesMapper;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper userMapper,RolesMapper rolesMapper,PasswordEncoder passwordEncoder){
        this.userMapper = userMapper;
        this.rolesMapper = rolesMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户名所有信息
        User user = userMapper.loadUserByUsername(s);
        if (user ==null){
            //避免返回null
            return new User();
        }
        //查询用户的角色信息,并返回存入user中
        List<Role> roles = rolesMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

    /**
     *  注册一个用户
     * @param user
     * @return 0表示成功
     * 1表示用户名重复
     * 2表示失败
     */
    public int reg(User user){
        //查询数据库是否已经有该用户名
        User loadUserByUsername = userMapper.loadUserByUsername(user.getUsername());
        if (loadUserByUsername !=null){
            return 1;
        }

        //插入用户,插入之前对密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //设置用户可用
        user.setEnabled(true);
        //注册用户
        long result = userMapper.reg(user);
        //配置用户的角色,默认是普通用户
        String[] roles = new String[]{"2"};
        //添加用户的角色信息
        int i = rolesMapper.addRoles(roles,user.getId());

        boolean b = i ==roles.length && result ==1 ;
        if (b){
            return  0;
        }else {
            return 2;
        }
    }

    public int updateUserEmail(String email){
        return userMapper.updateUserEmail(email, Util.getCurrentUser().getId());
    }

    public List<User> getByNickname(String nickname){
        List<User> list = userMapper.getUserByNickname(nickname);
        return list;
    }



    public List<Role> getAllRole(){
        List<Role> list =userMapper.getAllRole();
        return list;
    }

    //修改用户enabled
    public int updateUserEnabled(boolean enabled, Long uid){
        int i = userMapper.updateUserEnabled(enabled, uid);
        return i;
    };

    public int deleteUserById(Long id){
        int i = userMapper.deleteUserById(id);
        return i;
    }

    //更新用户角色
    public int updateUserRoles(Long[] rids,Long id){
        //删除 role_user 信息
        int i = userMapper.deleteUserRolesByUid(id);
        //插入 role_user 信息
        return userMapper.setUserRoles(rids,id);
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

}
