package com.lql.dao;

import java.util.List;

import com.lql.entity.Traveller;

public interface Dao {
	/**
	 * 通过id查找旅客
	 * 
	 * @param id
	 * @return
	 */
	Traveller getTravellerById(Integer id);

	/**
	 * 通过旅客对象增添数据
	 * 
	 * @param traveller
	 * @return 
	 */
	boolean insertTraveller(Traveller traveller);

	/**
	 * 通过id删除旅客记录
	 * 
	 * @param id
	 * @return
	 */
	boolean deletTravellerById(int id);

	/**
	 * 通过Traveller对象修改记录
	 * 
	 * @param traveller
	 * @return
	 */
	boolean updateTravellerByTraveller(Traveller traveller);

	/**
	 * 
	 * @return 对象集合
	 */
	List<Traveller> getAll();

}
