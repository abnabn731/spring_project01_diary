package com.example.diary.model.chart.dao;

import java.util.List;

import com.example.diary.model.chart.dto.ChartDTO;

public interface ChartDAO {

	public List<ChartDTO> chartlist();
	public void insert(ChartDTO dto); // 테스트 결과 저장

}
