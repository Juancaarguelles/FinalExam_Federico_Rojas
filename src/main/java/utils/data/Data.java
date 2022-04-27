package utils.data;

import org.testng.annotations.DataProvider;

public class Data
{
    @DataProvider(name = "create_accounts")
    public static Object[][]accounts()
    {
        return new Object[][]{{"tester2@yopmail.com", "12345qwerty"}};
    }
}
