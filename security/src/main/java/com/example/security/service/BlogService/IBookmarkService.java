package com.example.security.service.BlogService;

import com.example.security.model.Blog.BookmarkBlog;
import com.example.security.model.user.User;

import java.util.List;

public interface IBookmarkService {
    List<BookmarkBlog> findAllBookmark();
    BookmarkBlog findByUserIdAndBlogId(Long userId, Long blogId);

    List<BookmarkBlog> findAllBookmarkByUser(User user);
    void save(BookmarkBlog bookmarkBlog);
    void delete(Long id);
}
