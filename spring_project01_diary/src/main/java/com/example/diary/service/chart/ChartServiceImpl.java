package com.example.diary.service.chart;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.example.diary.model.chart.dao.ChartDAO;
import com.example.diary.model.chart.dto.ChartDTO;

@Service
public class ChartServiceImpl implements ChartService {

	@Inject
	ChartDAO dao;
	
	@Override
	public List<ChartDTO> chartlist() {

		return dao.chartlist();
	}

	@Override
	public void insert(ChartDTO dto) {	
		dao.insert(dto);
	}	


}
