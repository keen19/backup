package keen.ui;

import keen.service.AccountService;
import keen.service.impl.AccountServiceImpl;

/**
 * 模拟一一个表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
