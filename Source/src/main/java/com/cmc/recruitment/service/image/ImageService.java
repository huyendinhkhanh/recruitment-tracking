package com.cmc.recruitment.service.image;

import java.util.List;

import com.cmc.recruitment.model.Image;

public interface ImageService {

	Image findImageById(long id);

	void saveImage(Image image);

	void updateImage(Image image);

	void deleteImageById(long id);

	List<Image> getAllImages();

}
