package com.mashibing;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

public class MyInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    public Object plugin(Object target) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
