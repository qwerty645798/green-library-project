package com.library.repository.assets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.library.dto.assets.DataSearchResultDto;
import com.library.dto.assets.PopularBookDto;

@Repository
public class DataSearchResultRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<DataSearchResultDto> findBookId() {
		String sql = "SELECT book_id, img, title, availability, author_name, location, publisher_name, isbn, summary "
		           + "FROM ("
		           + "SELECT b.book_id, b.img, b.title, b.availability, a.author_name, b.location, p.publisher_name, b.isbn, b.summary "
		           + "FROM books b "
		           + "JOIN authors a ON b.author_id = a.author_id "
		           + "JOIN publishers p ON b.publisher_id = p.publisher_id "
		           + "ORDER BY b.book_id"
		           + ") ";//조건문 고치는중 ( 여기에 셀렉트에 내용 일치 확인문 )
		return jdbcTemplate.query(sql, new RowMapper<DataSearchResultDto>() {
			@Override
			public DataSearchResultDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataSearchResultDto book = new DataSearchResultDto();
                book.setBookId(rs.getInt("book_id"));
                book.setImg(rs.getString("img"));
                book.setTitle(rs.getString("title"));
                book.setAvailability(rs.getString("availability")); 
                book.setAuthorName(rs.getString("author_name"));
                book.setLocation(rs.getString("location"));
                book.setPublisherName(rs.getString("publisher_name")); 
                
                book.setIsbn(rs.getString("isbn"));
                book.setSummary(rs.getString("summary"));
                                
                if (book.getAvailability() != null) {
                    if (book.getAvailability().equals("1")) {
                        book.setAvailability("대출가능");
                    } else {
                        book.setAvailability("대출불가");
                    }
                } else {
                    book.setAvailability("알수없음");
                }
                
				return book;
			}
		});
	}
}
