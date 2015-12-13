package com.applepie1130.image;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 이미지를 URL로 가져와서 이미지 정보 받아오기
 * 
 * @author applepie1130
 */
public class ImagingProcess {
	
	private final static Integer BUFFER_SIZE = 4096;
	
	private static final Logger logger = LoggerFactory.getLogger(ImagingProcess.class);
	
	
	/**
	 * getImageFromURL() : 이미지 URL로 다운받아 File로 쓰기
	 * 
	 * @param url
	 * @param file
	 * @throws IOException
	 */
	public static void getImageFromURL(URL url, File file) throws IOException {
		
		OutputStream outputStream = null;
		InputStream inputStream = null;
		byte[] buf = new byte[BUFFER_SIZE];
		int byteRead;
		
		try {
			// 디렉토리 없으면 생성 
			if (file.getParentFile() != null) {
				file.getParentFile().mkdirs();
			}

			outputStream = new BufferedOutputStream( new FileOutputStream(file) );
			inputStream = url.openConnection().getInputStream();
			
			while ( (byteRead = inputStream.read(buf)) != -1 ) {
				outputStream.write(buf, 0, byteRead);
			}

		} catch (IOException e) {
			throw e;
			
		} finally {
			
			if (inputStream != null) {
				inputStream.close();
			}
			
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}
		logger.info("이미지 다운 성공, URL : {}, 저장경로 : {}", url, file);
	}
	
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 * @throws IOException 
	 * @throws ImageReadException 
	 */
	public static void main(String[] args) throws IOException, ImageReadException {
		
		// 이미지 다운받아 저장시킬 경로
		DateTime dateTime = new DateTime();
		URL url = new URL("http://news.nateimg.co.kr/orgImg/tn/2015/09/17/2015091711444107811_1.jpg");

		// 파일이름만 추출 (확장자 포함)
		String fileNameWithExtension = FilenameUtils.getName(url.toString());
		File file = new File("/tank0/resource/image/" + dateTime.toString("yyyyMMdd") + "/" + fileNameWithExtension);
		
		// 이미지 다운받아 해당 경로에 이미지 저장
		getImageFromURL(url, file);
		
		// 해당 이미지의 이미지정보 받아오기
		ImageInfo imageInfo = Imaging.getImageInfo(file);
		logger.info("다운받은 이미지 정보 \n{}", imageInfo);
		
	}
}
