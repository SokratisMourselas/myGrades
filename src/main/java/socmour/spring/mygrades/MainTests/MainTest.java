package socmour.spring.mygrades.MainTests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import socmour.spring.mygrades.Config.DemoConfig;
import socmour.spring.mygrades.Entity.Account;
import socmour.spring.mygrades.Service.AccountServiceImpl;

import java.util.List;

public class MainTest {


    public static void main(String[] args) {
        //context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // retrieving bean from context
        AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);

        //adding account to check @Before Aspect expression
//        accountDAO.addAccount(123, "String Placeholder");

        System.out.println("<------------       Adding random Accounts      ------------>\n");
        List<Account> list = accountService.getAccounts();

        printAccounts(list);

        context.close();
    }

    public static void printAccounts(List<Account> list){
        int i =1;
        for (Account account: list) {
            System.out.println("Account No. "+ i +": "+ account.getName() + ", "+ account.getAge());
            i++;
        }
    }


}
