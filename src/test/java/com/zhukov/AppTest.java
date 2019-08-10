package com.zhukov;

import com.zhukov.main.App;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMain() throws IOException {
        String args[] = {"src/main/java/com/zhukov/input2.txt"};
        App.main(args);
    }
}
