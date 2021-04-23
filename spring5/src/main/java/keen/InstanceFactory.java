package keen;

import keen.dao.impl.AccountDaoImpl;

public class InstanceFactory {
    public InstanceFactory() {
    }

    public AccountDaoImpl getService(){
        return new AccountDaoImpl();
    }
}
