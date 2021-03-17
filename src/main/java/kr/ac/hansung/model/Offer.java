package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	@Size(min=2, max=50, message="과목명을 입력해주세요")
	private String s_name;
	private int year;
	private int semester;
	@Size(min=2, max=50, message="교과 구분을 입력해주세요")
	private String s_type;
	@Size(min=2, max=50, message="교수명을 입력해주세요")
	private String professor;
	private int grades;
	

}
