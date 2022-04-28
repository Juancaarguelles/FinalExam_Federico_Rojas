package utils.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class Data
{
    private static Random random;

    public static String name;
    public static String lastName;
    public static String email;
    public static String password;

    static {
        random = new Random();
        name = "Peter";
        lastName = "Parker";
        password = "12345qwerty";
    }


    public static void generateEmail()
    {
        StringBuilder randomEmail = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            randomEmail.append((char) (random.nextInt(26) + 'a'));
        }
        randomEmail.append("@yopmail.com");
        System.out.println("Generated email : "+randomEmail.toString());
        email = randomEmail.toString();
    }
}
