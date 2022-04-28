package utils.data;

import org.testng.annotations.DataProvider;

public class Data
{
    @DataProvider(name = "create_accounts")
    public static Object[][]createAccounts()
    {
        return new Object[][]{{"juan", "perrito", "juasfdgr@yopmail.com", "12345qwerty"}};
    }
}
