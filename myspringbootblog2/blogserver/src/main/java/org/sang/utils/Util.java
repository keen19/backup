package org.sang.utils;

import org.sang.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.plugin.liveconnect.SecurityContextHelper;

public class Util {
    public static User getCurrentUser(){
        User user = (User)SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal();
        return user;
    }
}
