package org.sang.contorller;

import org.sang.bean.RespBean;
import org.sang.service.UserService;
import org.sang.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserContorller {
    
    UserService userService;
    
    @Autowired
    UserContorller(UserService userService){
        this.userService = userService;
    }

    /**
     *  获取当前用户名
     * @return
     */
    @RequestMapping("/currentUserName")
    public String currentUserName(){
        return Util.getCurrentUser().getNickname();
    }

    /**
     * 获取当前用户id
     * @return
     */
    @RequestMapping("/currentUserId")
    public Long currentUserId(){
        return Util.getCurrentUser().getId();
    }

    /**
     * 获取当前用户邮箱
     * @return
     */
    @RequestMapping("/currentUserEmail")
    public String currentUserEmail(){
        return Util.getCurrentUser().getEmail();
    }
    
    public Boolean isAdmin(){
        List<GrantedAuthority> authorities = Util.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")){
                return true;
            }
        }

        return false;
    }

    /**
     * 更新用户邮箱
     * @param email
     * @return
     */
    public RespBean updateUserEmail(String email){
        if (userService.updateUserEmail(email) == 1){
            return new RespBean("success","开启成功");
        }
        return new RespBean("error","开启失败");
    }
}
