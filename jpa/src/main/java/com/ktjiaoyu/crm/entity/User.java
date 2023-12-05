package com.ktjiaoyu.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sys_user")
@NamedQueries(@NamedQuery(name = "User.findUsersByName", query = "SELECT u FROM User u WHERE u.usrName = ?1"))
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 37808849617026314L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long usrId;
    @Column(name = "usr_name")
    private String usrName;
    @Column(name = "usr_password")
    private String usrPassword;
    @Column(name = "usr_role_id")
    private Long usrRoleId;
    @Column(name = "usr_flag")
    private Integer usrFlag;

    public User(String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }
}
