package kr.kh.study.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	private String serviceKey = "N%2BpuuxU3gWDSEZeHQqsedd51t0EYAtuPDLnIYDX8cH1mqrLKtLNU4qwK2n2tmwuWQdCtYrCbgW2Xx68Xz8ie5w%3D%3D\r\n"
			+ "";
	
	@GetMapping("/api/test")
	public String Test() {
		return "test";
	}
	
	@ResponseBody // ajax니까
	@GetMapping("/api/request")
	public String request(@RequestParam("pageNo")int pageNo, @RequestParam("numOfRows")int numOfRows) throws Exception{
		
		  StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=serviceKey"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(""+pageNo, "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(""+numOfRows, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*호출문서 형식*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json;charset=utf-8");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	        return sb.toString();
	}
}
