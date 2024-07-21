package com.example.readingRecord.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.readingRecord.entity.Book;

@Mapper
public interface BookMapper {

	List<Book> selectAll();

	Book selectById(@Param("id") Integer id);

	void insert(Book book);

	void update(Book book);

	void delete(@Param("id") Integer id);
}
