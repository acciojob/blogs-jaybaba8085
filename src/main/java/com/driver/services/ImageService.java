package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

     @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        Image image = new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);

        List<Image> imageList = blog.getImageList();
        imageList.add(image);

        blog.setImageList(imageList);

        image.setBlog(blog);

        imageRepository2.save(image);
        blogRepository.save(blog);

        return image;
    }

    public void deleteImage(Image image){

            Blog blog = image.getBlog();
            List<Image> list = blog.getImageList();
            list.remove(image);
            blog.setImageList(list);
            imageRepository2.delete(image);

 }

    public Image findById(int id)
    {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        // given an image id and a screen size, find the number of images of given size
        // that can fit completely into the screen with given dimensions.
        // For example, a screen with dimensions 4X4, can completely fit 4 images,
        // each having dimensions 2X2.
        //In case the image is null, return 0

        //complete this function


        return 0;
    }
}
