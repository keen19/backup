package keen;

import keen.dao.impl.AccountDaoImpl;

public class StaticFactory {
    public static AccountDaoImpl getService(){
        return new AccountDaoImpl();
    }
}
