package com.example.diary.model.chart;

public class QuestResult {

	//테스트 결과가 담기는 객체
	//Service에서 @ModelAttribute로 데이터 가져오기
	//질문 개수대로 변수 생성하기
	public int q1;
	public int q2;
	public int q3;
	public int q4;
	public int q5;
	
	
	//테스트 결과를 점수로 받아와서 한 변수에 계속해서 더해주려면 
	//점수를 담은 변수를 매개값으로 다 받아와야한다
	//그러기엔 번거로우니까 아예 객체 하나에 다 받아와서
	//각각 변수의 값을 더해주면 된다
	
}
