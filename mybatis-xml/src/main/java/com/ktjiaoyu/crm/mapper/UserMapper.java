package com.ktjiaoyu.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ktjiaoyu.crm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /*@Insert("""
            INSERT INTO sys_user(usr_name, usr_password, usr_role_id, usr_flag)
            VALUES (#{usrName}, #{usrPassword}, #{usrRoleId}, #{usrFlag})
            """)
    void insert(User user);

    @Delete("DELETE FROM sys_user WHERE usr_id = #{id}")
    void delete(Long id);

    @Update("""
            <script>
                UPDATE sys_user
                <set>
                    <if test="usrName != null">
                        usr_name = #{usrName},
                    </if>
                    <if test="usrPassword != null">
                        usr_password = #{usrPassword},
                    </if>
                    <if test="usrRoleId != null">
                        usr_role_id = #{usrRoleId},
                    </if>
                    <if test="usrFlag != null">
                        usr_flag = #{usrFlag}
                    </if>
                </set>
                WHERE usr_id = #{usrId}
            </script>
            """)
    void update(User user);

    @Select("SELECT * FROM sys_user WHERE usr_id = #{id}")
    @Result(column = "usr_id", property = "usrId")
    @Result(column = "usr_name", property = "usrName")
    @Result(column = "usr_password", property = "usrPassword")
    @Result(column = "usr_role_id", property = "usrRoleId")
    @Result(column = "usr_flag", property = "usrFlag")
    User get(Long id);

    @Select("SELECT * FROM sys_user")
    @Result(column = "usr_id", property = "usrId")
    @Result(column = "usr_name", property = "usrName")
    @Result(column = "usr_password", property = "usrPassword")
    @Result(column = "usr_role_id", property = "usrRoleId")
    @Result(column = "usr_flag", property = "usrFlag")
    List<User> findAll();*/
}
