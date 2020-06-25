package net.praveen.artgallery.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "F:\\PROJECT\\CdacProject\\JAVA\\art-gallery\\artgallery\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH ="";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String prod_code) {

		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);					
		// create the directories if it does not exist
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + prod_code + ".jpg"));
			file.transferTo(new File(ABS_PATH + prod_code + ".jpg"));
		}
		catch(IOException ex) {
			
		}
		
	}



	
	
}
