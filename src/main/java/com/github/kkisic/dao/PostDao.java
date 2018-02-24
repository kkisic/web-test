package com.github.kkisic.dao;

import java.util.List;

import com.github.kkisic.entity.Post;
import com.github.kkisic.cofiguration.DatabaseConfigulation;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.Delete;

@Dao(config = DatabaseConfigulation.class)
public interface PostDao {
    @Select
    List<Post> selectAll();
    @Insert
    int insert(Post post);
    @Update
    int update(Post post);
    @Delete
    int delete(Post post);
}
