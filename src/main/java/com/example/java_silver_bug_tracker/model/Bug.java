package com.example.java_silver_bug_tracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bug {
    private String title;
    private String detail;
    private long id;
    private String priority;

    @Id // ← ★これが必要です！「これが主キー(ID)だよ」という目印
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ← IDを自動採番する設定

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
}

