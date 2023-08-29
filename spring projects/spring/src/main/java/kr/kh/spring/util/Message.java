package kr.kh.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
	private String url, msg;
	
	public String toString() {
		return "{" + "mag : '" + msg + "', url : '" + url + "'}";
	}

}
