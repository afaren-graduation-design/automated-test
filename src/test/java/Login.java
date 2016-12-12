import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.Objects;

@FullOGNL
@RunWith(ConcordionRunner.class)
public class Login {

    class User {
        String account ;
        String password;
    }

    User user;

    @Before
    public void setUp() throws Exception {
        user  = new User();
        user.account = "afaren";
        user.password = "12345678";
    }

    public String login(String account, String password) {
        if (Objects.equals(account, user.account) && Objects.equals(password, user.password)) {
            return "login";
        }
        return "reject";
    }
}
