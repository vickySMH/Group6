package People;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Random;

public class User implements Serializable
{
    private String username;
    private String password;


    public User()
    {
        username = "";
        generateRandomPass();
    }

    public User(String username)
    {
        this.username = username;
        generateRandomPass();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    private void generateRandomPass()
    {
        Random random = new Random();
        password = random.ints(48, 122 + 1).filter(i -> (i <= 57) || (i >=65))
                .limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    
}
