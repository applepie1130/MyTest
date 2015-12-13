package com.applepie1130.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP를 이용한 FTP 클라이언트 테스트
 * 
 * @author applepie1130
 */
public class FTPClientTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FTPClientTest.class);
	
	// FTP Server IP
	private final static String FTP_SERVER_IP = "127.0.0.1";
	
	// FTP 계정
	private final static String FTP_USER = "applepie1130";
	private final static String FTP_PWD = "tjdwns1130";
	
	// Keep Alive 
	private final static Integer FTP_CONTROL_KEEP_ALIVE_TIMEOUT = 300;
	
	// 타임아웃 10초
	private final static Integer FTP_CONNECTION_TIMEOUT = 10000;
	
	// upload 경로
	private final static String UPLOAD_DIR = "/tank0/resource/ftp/";
	
	//  upload 할 file이 들어있는 경로
	private final static String FILE_DIR = "/tank0/resource/image/20151213/";
	
	
	/**
	 * 메인 메소드
	 * 
	 * @param	args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		List<String> ftpServers = Arrays.asList(FTP_SERVER_IP);
		List<FTPClient> ftpClients = new ArrayList<FTPClient>();
		
		File fileSrcList = new File(FILE_DIR);
		List<File> files = Arrays.asList(fileSrcList.listFiles());
		
		try {	
			// 서버별 연결 후 업로드 할 디렉토리 생성 
			for ( String server : ftpServers ) {
				FTPClient ftpClient = new FTPClient(); 
				ftpClient.setConnectTimeout(FTP_CONNECTION_TIMEOUT);
				ftpClient.connect(server);
				
				// FTP 로그인 접속
				if( !ftpClient.login(FTP_USER, FTP_PWD) ) {
					throw new Exception("로그인정보 오류 : 서버IP=" + server + ", Massage="+ftpClient.getReplyString());
	            }
				
				// FTP 설정
				ftpClient.enterLocalActiveMode();
				ftpClient.setControlKeepAliveTimeout(FTP_CONTROL_KEEP_ALIVE_TIMEOUT);
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				
				int reply = ftpClient.getReplyCode();
				
	            if ( !FTPReply.isPositiveCompletion(reply) ) {
	                ftpClient.disconnect();
	                throw new Exception("FTP 접속 실패! : 서버IP=" + server + ", Massage="+ftpClient.getReplyString());
	            }
	            
	            // FTP 서버댓수 만큼 접속 객체 추가 
	            ftpClients.add(ftpClient);
	            
				// 디렉토리 생성, 부모 디렉토리 없으면 함께 생성
            	// 이미 디렉토리가 만들어 진 경우는 550코드를 리턴 해서, 넘어가게 처리
	            logger.info("업로드 대상 경로 (존재하지 않으면 생성) : {}", UPLOAD_DIR);
	            boolean isMake = ftpClient.makeDirectory(UPLOAD_DIR);
            	
            	if ( !isMake && ftpClient.getReplyCode() != 550 ) {
            		throw new Exception("FTP 디렉토리 생성 실패 : 디렉토리=" + UPLOAD_DIR + ", 서버IP=" + server + ", Massage="+ftpClient.getReplyString());
            	}
            	if (!ftpClient.changeWorkingDirectory(UPLOAD_DIR)) {
            		throw new Exception("FTP 디렉토리 이동 실패 : 디렉토리=" + UPLOAD_DIR + ", 서버IP=" + server + ", Massage="+ftpClient.getReplyString());
            	}
			}
		
			// 파일 업로드
			for (File file:files) {
				for (FTPClient ftpClient:ftpClients) {
					
					logger.info("FTP서버의 해당경로에 파일 업로드");
					logger.info("Src : {}, Desc list : {}, 응답결과 : {}", file, ftpClient.listNames(), ftpClient.getReplyString());
					
					// Send File
					InputStream inputStream = new FileInputStream(file);
					ftpClient.storeFile(file.getName(), inputStream);
					inputStream.close();
				}
			}

		} catch (IOException e) {
			throw e;
			
		} finally {
			// FTP 연결 종료 
			for ( FTPClient ftpClient:ftpClients ) {
				if ( ftpClient.isConnected() ) {
					try {
						ftpClient.logout();		
						ftpClient.disconnect();
					} catch (IOException ioe) {
						// do nothing
					}
				}
			}
			
			logger.info("FTP 접속 종료");
		}
	}
}
