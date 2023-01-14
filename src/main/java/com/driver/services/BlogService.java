package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    @Autowired
    ImageRepository imageRepository;

    public List<Blog> showBlogs(){

      List<Blog> blogList =blogRepository1.findAll();
      return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog= new Blog();

        //updating the blog details

        blog.setContent(content);

        blog.setTitle(title);


        //Updating the userInformation and changing its blogs

        User user=userRepository1.findById(userId).get();

        List<Blog> blogs = user.getBlogList();
        blogs.add(blog);

        user.setBlogList(blogs);
        blog.setUser(user);

        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog

        Blog Blog=blogRepository1.findById(blogId).get();
        return Blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it


        Image image=new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);

        Blog blog= blogRepository1.findById(blogId).get();

        List<Image> imageList = blog.getImageList();

        imageList.add(image);

        blog.setImageList(imageList);
        image.setBlog(blog);
        blogRepository1.save(blog);


    }

    public void deleteBlog(int blogId){

        //delete blog and corresponding images
        Blog blog= blogRepository1.findById(blogId).get();

        List<Image> imageList = blog.getImageList();

        for(Image image: imageList)
        {
            imageRepository.delete(image);
        }

        User user = blog.getUser();
        List<Blog> blogList = user.getBlogList();

        blogList.remove(blog);
        user.setBlogList(blogList);

        blogRepository1.delete(blog);
        userRepository1.save(user);

    }
}
