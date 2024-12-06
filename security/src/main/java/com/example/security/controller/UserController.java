package com.example.security.controller;

import com.example.security.common.EncryptPasswordUtils;
import com.example.security.model.Blog.Blog;
import com.example.security.model.Blog.BookmarkBlog;
import com.example.security.model.Blog.LikeBlog;
import com.example.security.model.user.Role;
import com.example.security.model.user.User;
import com.example.security.repository.IBookmarkBlogRepo;
import com.example.security.repository.ICategoryRepository;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import com.example.security.service.BlogService.IBlogService;
import com.example.security.service.BlogService.IBookmarkService;
import com.example.security.service.CategoryService.ICategoryService;
import com.example.security.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    IUserService iUserService;
    @Autowired
    IBookmarkService iBookmarkService;
Boolean updated = true;
//Dien - quan ly user
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id")Long id,Model model){
        ModelAndView mv = new ModelAndView("redirect:/user/showList");
        Optional<User> user = iUserService.findUserById(id);
        user.get().setStatus(false);
        iUserService.save(user.get());
        return mv;
    }
    @GetMapping("/showMylistBlog")
    public String showMyListBlog(Model model,Principal principal){
        String email = principal.getName();
        User user = iUserService.findUserByEmail(email);
        List<Blog> blogs = user.getBlogs();
        model.addAttribute("user",user);
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogs",blogs);
        model.addAttribute("cate",iCategoryService.finAll());
        model.addAttribute("listDuyetBai", iBlogService.findByStatusFalse());
        if (updated.equals(false)){
            model.addAttribute("message" , "Cập nhật thành công");
        }
        return "/showMyListBlog";
    }
    @GetMapping("/showMyBookmark")
    public String showMyBookmark(Model model,Principal principal){
        String email = principal.getName();
        User user = iUserService.findUserByEmail(email);
        List<BookmarkBlog> bookmarkBlogs = user.getBookmarks();
        List<Blog> blogs = new ArrayList<>();
        for (int i = 0; i < bookmarkBlogs.size(); i++) {
            Blog blog = iBlogService.findOne(bookmarkBlogs.get(i).getBlog().getId());
            blogs.add(blog);
        }
        model.addAttribute("blog", new Blog());
        model.addAttribute("user",user);
        model.addAttribute("blogs",blogs);
        model.addAttribute("bookmarkBlogs",bookmarkBlogs);
        model.addAttribute("cate",iCategoryService.finAll());
        model.addAttribute("listDuyetBai",iBlogService.findByStatusFalse());
        return "/bookmark";
    }
    @GetMapping("/showMyLikedBlog")
    public String showMyLikedBlog(Model model,Principal principal){
        String email = principal.getName();
        User user = iUserService.findUserByEmail(email);
        List<LikeBlog> likeBlogs = user.getLikes();
        List<Blog> blogs = new ArrayList<>();
        ModelAndView mv = new ModelAndView("viewBlog");
        for (int i = 0; i < likeBlogs.size(); i++) {
            Blog blog = iBlogService.findOne(likeBlogs.get(i).getBlog().getId());
            blogs.add(blog);
        }
        model.addAttribute("blog", new Blog());
        model.addAttribute("user",user);
        model.addAttribute("blogs",blogs);
        model.addAttribute("likeBlogs",likeBlogs);
        model.addAttribute("cate",iCategoryService.finAll());
        model.addAttribute("listDuyetBai",iBlogService.findByStatusFalse());
        return "/liked";
    }

    @GetMapping("/showList")
    private ModelAndView showListUser(@RequestParam(defaultValue = "0") int page){
        Sort sort = Sort.by("email").ascending();
        Pageable pageable = PageRequest.of(page, 99, sort);
        Page<User> userList = iUserService.findAlll(pageable);
        ModelAndView mv = new ModelAndView("/userList");
        List<Role> roles = roleRepository.findAll();
//        List<User> userList = iUserService.findAll();
        mv.addObject("userList",userList);
        mv.addObject("listDuyetBai",iBlogService.findByStatusFalse());
        mv.addObject("blog",iBlogService.findAlll());
        mv.addObject("role",roles);
        mv.addObject("cate", iCategoryService.finAll());
        mv.addObject("blogs", new Blog());
        return mv;
    }

    @PostMapping("/updateProfile")
    private String updateProfile(@ModelAttribute("user") User user){
        User temp = iUserService.findUserByEmail(user.getEmail());
        temp.setBirthDay(user.getBirthDay());
        temp.setPhoneNumber(user.getPhoneNumber());
        temp.setUserName(user.getUserName());
        iUserService.save(temp);
        updated = false;
        return "redirect:/user/showMylistBlog";
    }

@GetMapping("/showRegister")
public String showRegister(Model model) {
    model.addAttribute("user", new User());
    return "register";
}
@PostMapping("/registration")
    public String onApplicationEvent(@ModelAttribute("user") User user, BindingResult bindingResult,Model model) {
        //them admin
        String email = user.getEmail();
        String pass = user.getPassword();
        if (userRepository.findByEmail(email) == null) {
            User admin = new User();
            admin.setEmail(email);
            // mã hóa mật khẩu
            admin.setPassword(EncryptPasswordUtils.EncryptPasswordUtils(pass));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_USER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }else{

        }
        return "redirect:/";
    }

}
