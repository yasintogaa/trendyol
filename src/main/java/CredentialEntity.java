import java.io.IOException;

class CredentialEntity{

    private String username;
    private String password;

    CredentialEntity() {
        ReadConfig readConfig = new ReadConfig();

        try {
            username = readConfig.getConfigValue("trendyol.username");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            password = readConfig.getConfigValue("trendyol.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
