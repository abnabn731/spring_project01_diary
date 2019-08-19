package com.example.diary.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.diary.service.chart.GoogleChartService;

@RestController
@Controller
@RequestMapping("/include/*")
public class GoogleChartController {

	@Inject
	GoogleChartService googleChartService;
	
	@RequestMapping("include/chart.do")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}
	
// view(jsp)로 넘어가지 않고 호출한 곳에 JSONObject를 리턴함	
	@RequestMapping("cart_money_list.do")
	public JSONObject cart_money_list() {
		return googleChartService.getChartData();
	}
	
}