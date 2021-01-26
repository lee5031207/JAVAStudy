package com.kh.toy.common.util.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.kh.toy.common.code.Code;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

public class FileUtil {
	
	private final int MAXSIZE = 1024 * 1024 * 10;
	
	
	//1. 유니크한 파일이름을 생성해서 저장(renameFileName 생성)
	//2. 저장 경로를 웹어플리케이션 외부로 지정
	//	    저장경로 +/연/월/일/ 폴더에 파일을 저장
	//3. 파라미터 데이터를 Map에 저장해 반환
	//4. 파일 삭제 메서드
	public void fileUpload(HttpServletRequest request) {
		try {
			MultipartParser mp = new MultipartParser(request, MAXSIZE);
			Part part = null;
			while((part = mp.readNextPart()) != null ) {
				if(part.isFile()) {
					FilePart userFile = (FilePart) part;
					//사용자가 파일을 올리지 않으면 FilePart가 생성되지 않는 것이 아니라
					//빈 FilePart객체가 넘어온다. 사용자가 파일을 첨부 하지 않으면 getFileName()이 null을 반환 
					if(userFile.getFileName() != null) {
						//파일을 저장할 경로 생성
						Calendar cal = Calendar.getInstance();
						int year = cal.get(Calendar.YEAR);
						int month = cal.get(Calendar.MONTH)+1;
						int date = cal.get(Calendar.DAY_OF_MONTH);
						String subPath = year + "/" + month + "/" + date + "/";
						
						//유니크한 파일이름
						String originFileName = userFile.getFileName(); 
						String extention = userFile.getFileName().substring(originFileName.lastIndexOf("."));
						UUID renameFileId = UUID.randomUUID();
						String renameFileName = renameFileId + extention;
						
						// 지정한 경로를 만든다 없으면 만들고 잇으면 냅두니까 분기 설정 안해도댐
						new File(Code.UPLOAD+subPath).mkdirs();
						
						File file = new File(Code.UPLOAD+subPath+renameFileName);
						
						userFile.writeTo(file);
					}
				}else if(part.isParam()) {
					System.out.println("sex");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
