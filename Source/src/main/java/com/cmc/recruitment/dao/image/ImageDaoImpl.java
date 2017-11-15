package com.cmc.recruitment.dao.image;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.model.Image;
import com.cmc.recruitment.model.Post;

@Repository("imageDao")
@Transactional
public class ImageDaoImpl extends AbstractDao<Integer, Image> implements ImageDao{
	
	public Image findImageById(long id) {return (Image) getSession().get(Image.class, id); }

	public void saveImage(Image image) {	}

	public void updateImage(Image image) {	}

	public void deleteImageById(long id) {	}

	public List<Image> getAllImages() {return (List<Image>) createEntityCriteria().list();}

}
