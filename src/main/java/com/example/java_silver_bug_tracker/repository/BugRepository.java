package com.example.java_silver_bug_tracker.repository;

import com.example.java_silver_bug_tracker.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {
    // ここに何も書かなくても、
    // .save() も .findAll() も .findById() も全部使えるようになります！
    // 嘘みたいですが、これがSpring Data JPAの魔法です。
}