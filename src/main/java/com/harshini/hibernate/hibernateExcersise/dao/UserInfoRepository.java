package com.harshini.hibernate.hibernateExcersise.dao;

import com.harshini.hibernate.hibernateExcersise.entity.UserInfo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    public Optional<UserInfo> findByName(String name);
}
