package com.example.readingRecord.form;

import com.example.readingRecord.entity.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {
	private Integer id;
	@NotBlank(message = "タイトルは必須です。")
	private String title;
	@Size(min = 1, max = 200, message = "メモは{min}~{max}文字以内で入力してください。")
	private String memo;
	private Status status;
	private Boolean isNew;
}