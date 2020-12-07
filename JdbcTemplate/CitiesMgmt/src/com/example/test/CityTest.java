package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.CityService;
import com.example.vo.CityVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
// @ContextConfiguration(classes = {ApplicationConfig.class})
class CityTest {
	@Autowired
	@Qualifier(value = "cityService")
	private CityService cityService;
	
	@Disabled @Test
	public void test() {
		List<CityVO> list = this.cityService.readAll("KOR");
		list.forEach(city -> System.out.println(city));
		assertEquals(70, list.size());
	}
	
	@Disabled @Test
	public void test1() {
		CityVO cityVO = new CityVO();
		cityVO.setName("Kangnam");
		cityVO.setCountryCode("KOR");
		cityVO.setDistrict("Seoul");
		cityVO.setPopulation(500000);
		this.cityService.create(cityVO);
		
		List<CityVO> list = this.cityService.readAll("KOR"); // select All
		assertEquals(71, list.size());
		
	}
	
	@Disabled @Test
	public void test2() {
		CityVO cityVO = this.cityService.read(4080);
		assertEquals("Kangnam", cityVO.getName());
	}
	
	@Disabled @Test
	public void test3() {
		CityVO cityVO = new CityVO();
		cityVO.setId(2331);
		cityVO.setPopulation(50000000);
		this.cityService.update(cityVO);
		
		CityVO cityVO1 = this.cityService.read(2331);
		assertEquals(50000000, cityVO1.getPopulation());
	}
	
	@Test
	public void test4() {
		this.cityService.delete(4080);
		List<CityVO> list = this.cityService.readAll("KOR"); // select All
		assertEquals(70, list.size());
	}
}
