package com.kh.toy.common.util.file;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.kh.toy.common.code.Code;
import com.kh.toy.common.util.encoding.EncodingUtil;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.sun.mail.handlers.multipart_mixed;

public class FileUtil {
	
	private final int MAXSIZE = 1024 * 1024 * 10;
	Map<String,List> multiPartMap = new HashMap<String, List>();
	
	//1. 유니크한 파일이름을 생성해서 저장(renameFileName 생성)
	//2. 저장 경로를 웹어플리케이션 외부로 지정
	//	    저장경로 +/연/월/일/ 폴더에 파일을 저장
	//3. 파라미터 데이터를 Map에 저장해 반환
	//4. 파일 삭제 메서드
	public Map<String,List> fileUpload(HttpServletRequest request) {
		try {
			MultipartParser mp = new MultipartParser(request, MAXSIZE);
			Part part = null;
			List<FileVo> fileList = new ArrayList<FileVo>();
			
			
			while((part = mp.readNextPart()) != null ) {
				if(part.isFile()) {
					FilePart userFile = (FilePart) part;
					//사용자가 파일을 올리지 않으면 FilePart가 생성되지 않는 것이 아니라
					//빈 FilePart객체가 넘어온다. 사용자가 파일을 첨부 하지 않으면 getFileName()이 null을 반환 
					if(userFile.getFileName() != null) {
						FileVo fileVo = getFileData(userFile);
						fileList.add(fileVo);
						//파일을 저장
						saveFile(userFile, fileVo);
					}
				}else if(part.isParam()) {
					// paramPart에 저장되어 있는 파라미터값을 받아서
					// key:value 형태로 저장, value는 list타입
					ParamPart params = (ParamPart) part;
					List paramList = getParamValue(params);
					multiPartMap.put(params.getName(), paramList);		
				}
			}		
			multiPartMap.put("fileData", fileList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multiPartMap;
	}
	
	public void deleteFile(String path) {
		File file = new File(Code.UPLOAD+path);
		file.delete();
	}
	
	//유니크한 파일이름을 생성해서 저장(renameFileName 생성)
	private String getRenameFileName(String originalFileName) { 
		String extention = originalFileName.substring(originalFileName.lastIndexOf("."));
		UUID renameFileId = UUID.randomUUID();
		String renameFileName = renameFileId + extention;
		return renameFileName;
	}
	
	private String getSubPath() {
		//파일을 저장할 경로 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		return year + "/" + month + "/" + date + "/";
	}
	
	private void saveFile(FilePart userFile, FileVo fileVo) throws IOException {
		new File(Code.UPLOAD+fileVo.getSavePath()).mkdirs();
		//파일을 저장
		File file = new File(Code.UPLOAD+fileVo.getSavePath()+fileVo.getRenameFileName());
		userFile.writeTo(file);
	}
	
	private List<String> getParamValue(ParamPart params) throws UnsupportedEncodingException{
		
		String paramName = params.getName(); // title, content
		String paramValue = params.getStringValue("UTF-8"); // title에 적은 내용, content에 적은 내용
		List paramList = null;
		
		if(multiPartMap.get(paramName) == null) { //이전에 같은 파라미터 이름으로 저장된 파라미터가 없다면
			paramList = new ArrayList<>();
		}else {                                   //이전에 같은 파라미터 이름으로 저장된 파라미터가 있다면
			paramList = multiPartMap.get(paramName);
		}
		//파라미터 값을 utf-8로 인코딩하여 반환
		paramList.add(paramValue);
		
		return paramList;
	}
	
	private FileVo getFileData(FilePart userFile) throws UnsupportedEncodingException {
		
		//원본 파일 명
		String originalFileName = new String(userFile.getFileName().getBytes("iso-8859-1"),"utf-8");
		
		//유니크한 파일이름
		String renameFileName = getRenameFileName(originalFileName);
		
		// 지정한 경로를 만든다 없으면 만들고 잇으면 냅두니까 분기 설정 안해도댐
		String subPath = getSubPath();
		
		//파일 정보를 vo에 저장
		FileVo fileVo = new FileVo();
		fileVo.setOriginFileName(originalFileName);
		fileVo.setRenameFileName(renameFileName);
		fileVo.setSavePath(subPath);
		
		return fileVo;
	}
}
