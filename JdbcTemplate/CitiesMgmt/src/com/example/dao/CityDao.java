package com.example.dao;

import java.util.List;

import com.example.vo.CityVO;

public interface CityDao {
	void insertCity(CityVO cityVO);
	CityVO selectCity(int id);
	List<CityVO> selectAllCities(String countryCode);
	void updateCity(CityVO cityVO);
	void deleteCity(int id);
}
