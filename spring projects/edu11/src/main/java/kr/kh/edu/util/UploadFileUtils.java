package kr.kh.edu.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	/**
	 * 파일을 uploadPath에 복사한 후 복사한 파일경로와 이름을 합쳐서 문자열로 반환하는 메소드
	 * 파일을 업로드한 날짜에 맞춰서 년/월/일 폴더가 생성되고 그 안에 업로드 
	 * - 파일 1천개 -> 하나의 폴더에 있는 경우 / 10개의 폴더가 있는 경우 : 읽어오는데 시간이 걸림
	 * - 파일을 분산해서 로딩시간을 줄이려고
	 * @param uploadPath
	 * @param originalFileName
	 * @param filedata
	 * @return
	 * @throws IOException 
	 * */
	public static String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {
		
		// 같은 파일명을 가지는 파일을 업로드할 때 덮어쓰기가 되지 않게 처리하는 작업
		UUID uuid = UUID.randomUUID(); // 범용고유식별자. 32자의 문자열. 
		String savedFileName = uuid.toString() + "_" + originalFileName; //(32+4=36자 UUID)=8-4-4-4-12_파일명
		
		// 한 폴더에 파일이 몰리지 않게 날짜별로 업로드 파일을 관리
		// 2023/09/01 폴더가 만들어지도록!
		String savedPath = calcPath(uploadPath); // (업로드 날짜를 기준으로)년/월/일 폴더가 없으면 생성하고, 생성된 경로를 반환
		
		// 실제 파일을 복사
		File target = new File(uploadPath + savedPath, savedFileName);
		FileCopyUtils.copy(fileData, target);
		return uploadFileName(savedPath, savedFileName);
		
	}
	
	private static String uploadFileName(String savedPath, String savedFileName) {
		String fileName = savedPath + File.separator + savedFileName;
		return fileName.replace(File.separator, "/");
	}

	/**
	 * uploadPath에 기준 날짜에 맞는 년/월/일 폴더가 없으면 생성하고, 폴더의 경로를 반환하는 메소드
	 * @Param uploadPath 년/월/일 폴더를 만들 부모 폴더
	 * @return 기준 날짜의 년/월/일 폴더 경로
	 * */
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance(); // 현재 날짜를 달력형태로 받음 / Date는 년월일로 받기 어렵
		// \\2023
		String yearPath = File.separator + cal.get(Calendar.YEAR); // 폴더 경로를 구분하는 구분자(운영체제에 맞게 구분자가 들어가도록 함)
		// \\09 => \\2023\\09
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH +1)); // month 0~11이기 때문에 +1해줌
		// \\01 => \\2023\09\01
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE)); // month 0~11이기 때문에 +1해줌

		// 실제 폴더를 생성하는 메소드
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {
		// datePath가 이미 존재하면, 폴더가 이미 있는 경우이므로 폴더를 더 만들 필요가 없음
		if(new File(uploadPath + paths[paths.length-1]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}

	public static void deleteFile(String uploadPath, String fi_name) {
		File file = new File(uploadPath+fi_name);
		if(file.exists()) {
			file.delete();
		}
	}
}
