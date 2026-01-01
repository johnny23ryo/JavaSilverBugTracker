package com.example.java_silver_bug_tracker.repository;
import com.example.java_silver_bug_tracker.model.Bug;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class BugRepository {
    private static final List<Bug> bugList = new ArrayList<>();

    public void save(Bug bug) {
        bugList.add(bug);

    }

    public List<Bug> findAll(){
        return bugList;
    }
}
