package kr.kh.edu.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	private int fi_num, fi_bo_num;
	private String fi_name,	fi_ori_name;
	
//	public FileVO() {
//		
//	}
	
	public FileVO(int fi_bo_num, String fi_name, String fi_ori_name) {
		super();
		this.fi_bo_num = fi_bo_num;
		this.fi_name = fi_name;
		this.fi_ori_name = fi_ori_name;
	} 
	
}