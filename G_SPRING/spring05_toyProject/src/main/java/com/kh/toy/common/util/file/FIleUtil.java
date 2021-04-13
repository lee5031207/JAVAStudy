package com.kh.toy.common.util.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.common.code.Code;

public class FIleUtil {

	public List<FileVo> fileUpload(List<MultipartFile> files) throws IllegalStateException, IOException{
		
		//파일 정보를 가지고 반환될 list
		List<FileVo> fileList = new ArrayList<FileVo>();
		
		//파일 저장 경로
		String savePath = getSavePath();
		
		if(files.size() >= 1 && !files.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multipartFile : files) {
				FileVo fileVo = new FileVo();
				fileVo.setOriginFileName(multipartFile.getOriginalFilename());
				fileVo.setRenameFileName(UUID.randomUUID().toString());
				fileVo.setSavePath(savePath);
				fileList.add(fileVo);
				saveFile(fileVo, multipartFile);
			}
		}

		return fileList;
	}
	
	private String getSavePath() {
		Calendar cal = Calendar.getInstance();
		String savePath = cal.get(Calendar.YEAR) + "/"
				+ cal.get(Calendar.MONTH+1) + "/"
				+ cal.get(Calendar.DAY_OF_MONTH) + "/";
		
		return savePath;
	}
	
	private void saveFile(FileVo fileVo, MultipartFile multipartFile) throws IllegalStateException, IOException {
		File dest = new File(fileVo.getFullPath() + fileVo.getRenameFileName());
		if(!dest.exists()) {
			new File(fileVo.getFullPath()).mkdirs();
		}
		multipartFile.transferTo(dest);
	}
}
