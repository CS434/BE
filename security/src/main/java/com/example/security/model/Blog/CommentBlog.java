package com.example.security.model.Blog;

import com.example.security.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class CommentBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String content;
    private String dateTime;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "blog")
    private Blog blog;
    public String formatDate(){
        LocalDateTime now = LocalDateTime.now();

        // Định dạng theo mẫu cụ thể và in ra chuỗi
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd , HH:mm"));
        return formattedDateTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public CommentBlog(Long id, String content, String dateTime, User user, Blog blog) {
        Id = id;
        this.content = content;
        this.dateTime = dateTime;
        this.user = user;
        this.blog = blog;
    }

    public CommentBlog() {
        this.dateTime = formatDate();

    }
}
