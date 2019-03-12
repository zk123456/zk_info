package com.domain;

import com.UserVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author zk
 * @Date 13:53 2019/3/8
 */

/**
 * /**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
public interface UserMapper {

    @Select("select * from temp_user where name = #{name}")
    List<TempUser> findByName(@Param("name") String name);

    /**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     */
    @Insert("insert into temp_user(name) values(#{name})")
    int insert(@Param("name")String name);

    /**
     * error
     */
    /*@Select("select name from temp_user where id = #{id}")
    List<String> findById(@Param("id")Long id);*/

    @Insert("insert into temp_user(name) values (#{name})")
    int insertByMap(Map<String,Object> map);

    @Insert("insert into temp_user(name) values (#{name})")
    int insertByObject(TempUser user);

    /**
     * 对于特殊输出vo或者dto的需要 results注解辅助
     * property是return的对象的属性
     * column是select的字段属性
     * @return
     */
    @Results(
            {
                    @Result(property = "d", column = "id"),
                    @Result(property = "name", column = "name")
            }
    )
    @Select("select id,name from temp_user")
    List<UserVO> findAll();
}
