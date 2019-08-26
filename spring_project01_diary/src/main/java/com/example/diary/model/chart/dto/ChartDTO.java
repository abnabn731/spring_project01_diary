package com.example.diary.model.chart.dto;

import java.util.Date;

public class ChartDTO {

	private int cno;
	private String id;
	private Date regdate;
	private int figure;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getFigure() {
		return figure;
	}
	public void setFigure(int figure) {
		this.figure = figure;
	}
	


}
