package com.example.readingRecord.form;

import com.example.readingRecord.entity.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

	private Integer id;
	private String title;
	private String memo;
	private Status status;
	private Boolean isNew;
}
