package com.github.kkisic.entity;

import java.sql.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String author;
    public Date time;
    public String body0;
    public String body1;
    public String body2;

    @Override
    public String toString() {
        return "[ " + id + ", " + author + ", " + time + ", " + body0 + ", " + body1 + ", " + body2 + " ]";
    }
}
