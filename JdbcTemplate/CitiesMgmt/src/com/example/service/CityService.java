package com.example.service;

import java.util.List;

import com.example.vo.CityVO;

public interface CityService {
	void create(CityVO cityVO);
	CityVO read(int id);
	List<CityVO> readAll(String countryCode);
	void update(CityVO cityVO);
	void delete(int id);
}
