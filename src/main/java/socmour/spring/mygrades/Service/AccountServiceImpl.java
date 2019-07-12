package socmour.spring.mygrades.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socmour.spring.mygrades.DAO.AccountDAO;
import socmour.spring.mygrades.Entity.Account;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    public List<Account> getAccounts() {
        return accountDAO.findAllAccounts();
    }
}
