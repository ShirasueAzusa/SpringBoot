package com.ktjiaoyu.crm.service.impl;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.repository.UserRepository;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public record UserServiceImpl(UserRepository userRepository) implements UserService {
    @Override
    public Page<User> findPageByMap(Map param, Pageable pageable) {
        return userRepository.findAll((Specification<User>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (param.get("usrName") != null) {
                predicates.add(criteriaBuilder.like(root.get("usrName"), "%" + param.get("usrName") + "%"));
            }
            if (param.get("roleId") != null) {
                predicates.add(criteriaBuilder.equal(root.get("usrRoleId"), param.get("roleId")));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
