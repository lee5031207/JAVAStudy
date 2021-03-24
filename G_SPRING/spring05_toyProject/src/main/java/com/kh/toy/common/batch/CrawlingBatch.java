package com.kh.toy.common.batch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawlingBatch {

	@Autowired
	BatchRepository batchRepository;
	
	//cron표현식
	//초 분 시 일 월 요일 연도
	// * : 모든
	// , : 복수 값을 지정
	// 시작시간/단위 : 시작시간부터 지정한 단위마다 실행
	// 3 * * 5 * * : 매달 5일 모든시간 모든분 3초마다 메서드 실행
	
	//@Scheduled(cron = "0 * * * * *")
	public void baseBallCrawling() throws MalformedURLException, IOException{
		
		URL url = new URL("https://www.koreabaseball.com/TeamRank/TeamRank.aspx");
		Document doc = Jsoup.parse(url, 1000);
		
		Elements eles = doc.select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
		
		//#{rank}, #{teamName}, #{match}, #{win}, #{loose}, #{tie}, #{rate}, #{regDate}
		String[] keyArr = {"rank","teamName","match","win","loose","tie","rate"};
		for (Element e : eles) {
			Map<String, String> data = new LinkedHashMap<String, String>();
			for(int i=0; i<7; i++) {
				data.put(keyArr[i], e.children().get(i).text());
			}
			batchRepository.insertBaseBall(data);
		}
		
		System.out.println("실행했다");
	}
	
	public void OceanCrawling() throws IOException {
		URL url = new URL("http://www.khoa.go.kr/oceangrid/koofs/kor/observation/obs_real_list.do");
		Document doc = Jsoup.parse(url, 10000);
		System.out.println(doc.select("contents_right"));
	}
}
