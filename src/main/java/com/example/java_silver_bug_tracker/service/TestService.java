package com.example.java_silver_bug_tracker.service;
import com.example.java_silver_bug_tracker.model.TestMessage;
import com.example.java_silver_bug_tracker.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestRepository repository;

    // コンストラクタでRepositoryを受け取る
    public TestService(TestRepository repository) {
        this.repository = repository;
    }

    public TestMessage getMessage() {
        return repository.findData();
    }
}
