package com.cmc.recruitment.dao.image;

import java.util.List;

import com.cmc.recruitment.model.Image;

public interface ImageDao {
	Image findImageById(long id);

	void saveImage(Image image);

	void updateImage(Image image);

	void deleteImageById(long id);

	List<Image> getAllImages();

}