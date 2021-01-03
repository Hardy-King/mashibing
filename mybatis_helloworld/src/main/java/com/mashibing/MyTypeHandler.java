package com.mashibing;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHandler implements TypeHandler {
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
