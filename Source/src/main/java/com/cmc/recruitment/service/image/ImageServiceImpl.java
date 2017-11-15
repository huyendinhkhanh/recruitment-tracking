package com.cmc.recruitment.service.image;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.dao.image.ImageDao;
import com.cmc.recruitment.dao.image.ImageDaoImpl;
import com.cmc.recruitment.model.Image;

@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	public Image findImageById(long id) {return imageDao.findImageById(id);}

	public void saveImage(Image Image) {}

	public void updateImage(Image Image) {imageDao.updateImage(Image);}

	public void deleteImageById(long id) {}

	public List<Image> getAllImages() {return imageDao.getAllImages();}
	
	

}
