package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

     @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        Image image=new Image();

        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(int id){


        Image image = imageRepository2.findById(id).get();

        imageRepository2.deleteById(id);

    }

    public Image findById(int id) {

        Image image=imageRepository2.findById(id).get();
        return image;
    }

    public int countImagesInScreen(int image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

        return 0;
    }
}
