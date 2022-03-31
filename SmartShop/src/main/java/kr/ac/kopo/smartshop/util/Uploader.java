package kr.ac.kopo.smartshop.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.smartshop.model.ProductImage;

public class Uploader<T extends UploadFile>{
	final String uploadPath = "d:/upload/";
	
	public List<T> makeList(List<MultipartFile> files, Class<T> type) throws Exception{
		List<T> result = new ArrayList<>();
		
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {		
				String filename = file.getOriginalFilename();  //파일 네임을 가져오고 
				String uuid = UUID.randomUUID().toString();    //uuid
				
				
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
					
					T item = type.newInstance();
					item.setFilename(filename);
					item.setUuid(uuid);
					
					result.add(item);
					}
			
				}
		return result;
	}

}
