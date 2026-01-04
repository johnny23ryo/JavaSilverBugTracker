package com.example.java_silver_bug_tracker.model;

public class TestMessage {
    //データを入れるフィールド
    private String content;

    // コンストラクタ
    public TestMessage(String content) {
        this.content = content;
    }

    // Getter(中身を取り出すメソッド)
    public String getContent() {
        return content;
    }

}
