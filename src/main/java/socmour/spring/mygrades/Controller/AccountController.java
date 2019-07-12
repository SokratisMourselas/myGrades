package socmour.spring.mygrades.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import socmour.spring.mygrades.Entity.Account;
import socmour.spring.mygrades.Service.AccountService;

import java.util.List;

@Component
@RequestMapping("/accounts")
public class AccountController {

    //injecting AccountDAO
    @Autowired
    private AccountService accountService;


    @GetMapping("/list")
    public String listCustomers() {

        //get Accounts from dao
//        List<Account> theAccounts = accountService.getAccounts();

        // add users to the SpringMVC model
//        theModel.addAttribute("accounts", theAccounts);

        System.out.println("================================= I AM HERE =======================");
        return "list-accounts";
    }

}
