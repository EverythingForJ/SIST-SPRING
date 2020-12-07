package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CityDao;
import com.example.vo.CityVO;

@Service("cityService")
public class CityServiceImple implements CityService {
	@Autowired
	private CityDao cityDao;
	
	
	@Override
	public void create(CityVO cityVO) {
		this.cityDao.insertCity(cityVO);
	}

	@Override
	public CityVO read(int id) {
		return this.cityDao.selectCity(id);
	}

	@Override
	public List<CityVO> readAll(String countryCode) {
		return this.cityDao.selectAllCities(countryCode);
	}

	@Override
	public void update(CityVO cityVO) {
		this.cityDao.updateCity(cityVO);
	}

	@Override
	public void delete(int id) {
		this.cityDao.deleteCity(id);
	}

}
