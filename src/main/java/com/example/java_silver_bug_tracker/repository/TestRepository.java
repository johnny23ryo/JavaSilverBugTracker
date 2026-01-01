package com.example.java_silver_bug_tracker.repository;

import com.example.java_silver_bug_tracker.model.TestMessage;
import org.springframework.stereotype.Repository;

@Repository // Springに「これはリポジトリ」だと教えるアノテーション

public class TestRepository {
    public TestMessage findData() {
        return new TestMessage("成功");
    }
}
