package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.CityVO;

@Repository("cityDao")
public class CityDaoImplJdbcTemplate implements CityDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insertCity(CityVO cityVO) {
		String sql ="INSERT INTO city(name, countrycode, district, population)" + "VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, cityVO.getName(), cityVO.getCountryCode(), cityVO.getDistrict(), cityVO.getPopulation());
		
	}

	@Override
	public CityVO selectCity(int id) {
		String sql = "SELECT * FROM city WHERE id=?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<CityVO>() {

			@Override
			public CityVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityVO city = new CityVO(rs.getInt("id"), rs.getString("name"), rs.getString("countrycode"), rs.getString("district"), rs.getInt("population"));
				return city;
			}
			
		}, id);
	}

	@Override
	public List<CityVO> selectAllCities(String countryCode) {
		String sql = "SELECT * FROM city WHERE countrycode=?";
		return this.jdbcTemplate.query(sql, new RowMapper<CityVO>() {

			@Override
			public CityVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityVO city = new CityVO(rs.getInt("id"), rs.getString("name"), rs.getString("countrycode"), rs.getString("district"), rs.getInt("population"));
				return city;
			}
			
		},countryCode);
	}

	@Override
	public void updateCity(CityVO cityVO) {
		String sql ="UPDATE city SET population=? WHERE id = ?";
		this.jdbcTemplate.update(sql, cityVO.getPopulation(), cityVO.getId());
	}

	@Override
	public void deleteCity(int id) {
		String sql = "DELETE FROM city WHERE id = ?";
		this.jdbcTemplate.update(sql, id);
	}

}
