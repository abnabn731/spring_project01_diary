package com.example.diary.controller.chart;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diary.model.chart.QuestResult;
import com.example.diary.model.chart.dto.ChartDTO;
import com.example.diary.service.chart.ChartService;

@Controller
public class ChartController {

	
	@Inject
	ChartService chartservice;
	
	@RequestMapping("chart/quest.do")
	public String questionnaire() {
		
		return "chart/questionnaire";
	}
	
	@RequestMapping("chart/list.do")
	public List<ChartDTO> chartlist() {

		return chartservice.chartlist();
	}

	
	 @RequestMapping("chart/insert.do") 
	 public void insert(@ModelAttribute QuestResult qr) {
	 
	 Date regdate = new Date();
	 
	 ChartDTO dto = new ChartDTO();
	 dto.setFigure(qr.q1+qr.q2+qr.q3+qr.q4+qr.q5); // 작성일자는 자동생성되도록
	 dto.setRegdate(regdate);
	 
	 chartservice.insert(dto); }
	 
	//같은 날짜에 테스트를 또 하게된다면
	//sql에서 regdate가 중복될 시 내용을 update해주면 된다.
}
