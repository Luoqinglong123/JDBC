package com.lql.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lql.dao.Dao;
import com.lql.dao.impl.DaoImpl;
import com.lql.entity.Traveller;

public class DaoTest {
	private static Dao dao = null;

	@Before
	public void init() {
		dao = new DaoImpl();
	}

	@Test
	public void testGetTravellerById() {
		Traveller traveller = dao.getTravellerById(1);
		System.out.println(traveller);
	}

	@Test
	public void testInsertTraveller() {
		long time = new java.util.Date().getTime();
		Date birth = new Date(time);
		Traveller traveller = new Traveller("zhangsan", "male", birth,
				"4586489456");
		boolean result = dao.insertTraveller(traveller);
		System.out.println(result ? "添加成功" : "添加失败");
	}

	@Test
	public void testDeletTravellerById() {
		boolean result = dao.deletTravellerById(1);
		System.out.println(result ? "删除成功" : "删除失败");
	}

	@Test
	public void testUpdateTravellerByTraveller() {
		try {
			String birthdayStr = "1986-2-21";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date time = sdf.parse(birthdayStr);
			Date birth = new Date(time.getTime());
			Traveller traveller = new Traveller(2, "qq", "male", birth,
					"456789123");
			boolean result = dao.updateTravellerByTraveller(traveller);
			System.out.println(result ? "更新成功" : "更新失败");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAll() {
		List<Traveller> all = dao.getAll();
		for (Traveller traveller : all) {
			System.out.println(traveller);
		}
	}

}
