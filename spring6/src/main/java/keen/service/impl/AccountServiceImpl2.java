package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;
import keen.service.AccountService;

import java.util.*;

/**
 * @author keen1
 */
public class AccountServiceImpl2 implements AccountService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl2{" +
                "\nmyStrs=" + Arrays.toString(myStrs) +
                ", \nmyList=" + myList +
                ", \nmySet=" + mySet +
                ", \nmyMap=" + myMap +
                ", \nmyProps=" + myProps +
                '}';
    }

    @Override
    public void saveAccount() {
        System.out.println("ac的saveAccount()方法调用了");
    }

}
