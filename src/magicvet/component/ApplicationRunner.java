package magicvet.component;

public class ApplicationRunner {

    EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.registerClients();
        }
    }
}