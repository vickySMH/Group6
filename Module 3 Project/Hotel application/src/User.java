import java.nio.charset.Charset;
import java.util.Random;

public class User
{
    private String username;
    private String password;

    public User(String username)
    {
        this.username = username;
        generateRandomPass();
    }

    private void generateRandomPass()
    {
        Random random = new Random();
        password = random.ints(48, 122 + 1).filter(i -> (i <= 57) || (i >=65))
                .limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    
}
