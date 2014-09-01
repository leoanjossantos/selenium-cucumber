package demo.activeadmin.info.resources.steps;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import demo.activeadmin.info.resources.pages.DashboardPage;
import demo.activeadmin.info.resources.pages.LoginPage;
import demo.activeadmin.info.resources.pages.SignUpPage;
import demo.activeadmin.info.resources.support.domain.User;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinition {

    @Quando("^eu registro o seguinte usuário:$")
    public void eu_registro_o_seguinte_usuário(DataTable inputs) throws Throwable {
        SignUpPage.access();
        User user = (User) inputs.asList(User.class).get(0);
        SignUpPage.signUp(user);
    }

    @Então("^vejo a seguinte mensagem: \"([^\"]*)\"$")
    public void vejo_a_seguinte_mensagem(String output) throws Throwable {
        assertTrue(DashboardPage.displaysMessage(output));
    }

    @Quando("^eu logar com os dados:$")
    public void eu_logar_com_os_dados(DataTable inputs) throws Throwable {
        LoginPage.access();
        User user = (User) inputs.asList(User.class).get(0);
        LoginPage.login(user);
    }

    @Então("^sould see message of the welcomes \"([^\"]*)\"$")
    public void sould_see_message_of_the_welcomes(String output) throws Throwable {
        assertTrue(DashboardPage.displaysWelcomeMessage(output));
    }

}
