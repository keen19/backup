package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Role;

import java.util.List;

@Mapper
public interface RolesMapper {
    //添加角色
    int addRoles(@Param("roles") String [] roles,@Param("uid") Long uid);

    //查询角色uid
    List<Role> getRolesByUid(Long uid);
}
