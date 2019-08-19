package com.example.diary.model.chart.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.diary.model.chart.dto.ChartDTO;

@Repository
public class ChartDAOImpl implements ChartDAO {

	@Inject
	SqlSession sqlsession;
	
	@Override
	public List<ChartDTO> chartlist() {
		return sqlsession.selectList("chart.list");
	}

	@Override
	public void insert(ChartDTO dto) {
		sqlsession.insert("chart.insert", dto);
	}

}
