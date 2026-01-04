package com.example.java_silver_bug_tracker.service;
import com.example.java_silver_bug_tracker.model.Bug;
import com.example.java_silver_bug_tracker.repository.BugRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BugService {
    private final BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public List<Bug> findAll() {
        return bugRepository.findAll();
    }
}
