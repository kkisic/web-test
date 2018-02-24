package com.github.kkisic.cofiguration;

import javax.sql.DataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;

public class DatabaseConfigulation implements org.seasar.doma.jdbc.Config {
    @Override
    public DataSource getDataSource() {
        return null;
    }
    @Override
    public Dialect getDialect() {
        return new H2Dialect();
    }
}
