package com.example.security.service.BlogService;

import com.example.security.model.Blog.BookmarkBlog;
import com.example.security.model.user.User;
import com.example.security.repository.IBookmarkBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService implements IBookmarkService{
    @Autowired
    IBookmarkBlogRepo bookmarkBlogRepo;
    @Override
    public List<BookmarkBlog> findAllBookmark() {
        List<BookmarkBlog> bookmarkBlogs = bookmarkBlogRepo.findAll();
        return bookmarkBlogs;
    }

    @Override
    public BookmarkBlog findByUserIdAndBlogId(Long userId, Long blogId) {
        return bookmarkBlogRepo.findByUserIdAndBlogId(userId,blogId);
    }

    @Override
    public List<BookmarkBlog> findAllBookmarkByUser(User user) {
        List<BookmarkBlog> bookmarkBlogs = bookmarkBlogRepo.findBookmarkBlogByUser(user);
        return bookmarkBlogs;
    }


    @Override
    public void save(BookmarkBlog bookmarkBlog) {
        bookmarkBlogRepo.save(bookmarkBlog);
    }

    @Override
    public void delete(Long id) {
        bookmarkBlogRepo.deleteById(id);
    }
}
