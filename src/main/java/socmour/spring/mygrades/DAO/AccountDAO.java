package socmour.spring.mygrades.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import socmour.spring.mygrades.Entity.Account;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Account> findAllAccounts() {

        Session currentSession = sessionFactory.getCurrentSession();

        //creating query
//        Query<Account> theQuery = currentSession.createQuery("from Account order by name", Account.class);

        Account account = currentSession.get(Account.class, 1);

        List<Account> accountList = new ArrayList<Account>();

        accountList.add(account);

        // returning results
//        return theQuery.getResultList();
        
        return accountList;

    }


}
