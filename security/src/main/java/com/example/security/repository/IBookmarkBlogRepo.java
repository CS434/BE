package com.example.security.repository;

import com.example.security.model.Blog.BookmarkBlog;
import com.example.security.model.Blog.LikeBlog;
import com.example.security.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookmarkBlogRepo extends JpaRepository<BookmarkBlog, Long> {

    List<BookmarkBlog> findBookmarkBlogByUser(User user);
    BookmarkBlog findByUserIdAndBlogId(Long userId, Long blogId);

}
