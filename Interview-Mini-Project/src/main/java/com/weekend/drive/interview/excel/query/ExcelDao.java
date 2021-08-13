package com.weekend.drive.interview.excel.query;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExcelDao {
	
	private int id;
	private String name;
	private char gender;
	private Date date;

}
