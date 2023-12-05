package com.ktjiaoyu.crm.repository;

import com.ktjiaoyu.crm.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    List<User> findByUsrName(String usrName);

    List<User> findByUsrNameAndUsrPassword(String usrName, String usrPassword);

    Long countByUsrName(String usrName);

    List<User> findByUsrNameLike(String usrName);

    @Query("select u from User u where u.usrRoleId = :roleId")
    List<User> findByRoleId(@Param("roleId") Long roleId);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User u set u.usrName = ?1 where u.usrId = ?2")
    int modifyNameById(String usrName, Long usrId);

    @Query("select u from User u where u.usrRoleId = ?1")
    Page<User> findPageByUsrRoleId(Long roleId, Pageable pageable);
}
