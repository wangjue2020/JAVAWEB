package com.test;

import com.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void testGetConnectionAndCloseConnection(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JDBCUtils.getConncection();
            System.out.println(conn);
            JDBCUtils.closeConnect(conn);
        }

    }
}
