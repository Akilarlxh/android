package com.totalo.moreinfo;

import com.totalo.moreinfo.java.service.Login;
import com.totalo.moreinfo.java.service.LoginImpl;
import com.totalo.moreinfo.Utils.MD5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void see(){
        String pa = "123456789";
        System.out.print(MD5.encode(pa));
        Login login = new LoginImpl();
        login.login("1","2");
    }

}