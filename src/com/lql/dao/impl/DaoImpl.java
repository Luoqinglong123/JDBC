package com.lql.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.f;
import oracle.net.aso.r;
import oracle.net.aso.s;

import org.junit.Test;

import com.lql.dao.Dao;
import com.lql.entity.Traveller;
import com.lql.utils.SqlUtils;

public class DaoImpl implements Dao {
	private static Connection connection = null;
	static {
		connection = SqlUtils.getConnection();
	}

	@Test
	public void test() {
		System.out.println(connection);
	}

	@Override
	public Traveller getTravellerById(Integer id) {
		Traveller traveller = null;
		ResultSet query = null;
		PreparedStatement statement = null;
		String sql = "select * from ta_psr where id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			query = statement.executeQuery();
			while (query.next()) {
				Integer id1 = query.getInt(1);
				String name = query.getString(2);
				String sex = query.getString(3);
				Date birth = query.getDate(4);
				String FLT_NUMBER = query.getString(5);
				traveller = new Traveller(id1, name, sex, birth, FLT_NUMBER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.closeRealse(statement, connection, query);
		}
		return traveller;

	}

	@Override
	public boolean insertTraveller(Traveller traveller) {
		boolean flag = false;
		PreparedStatement statement = null;
		String sql = "INSERT INTO ta_psr(id,name,sex,FLT_NUMBER) VALUES(?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			long itemId = SqlUtils.getItemId();
			statement.setInt(1,  (int) itemId);
			statement.setString(2, traveller.getName());
			statement.setString(3, traveller.getSex());
			//statement.setDate(4, traveller.getBirth());
			statement.setString(4, traveller.getFLT_NUMBER());
			statement.executeUpdate();
			connection.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SqlUtils.closeRealse(statement, connection, null);
		}
		
		return flag;
	}

	@Override
	public boolean deletTravellerById(int id) {
		boolean flag = false;
		PreparedStatement statement = null;
		ResultSet query = null;
		try {
			connection.setAutoCommit(false);
			String sql = "delete  from ta_psr where  id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			flag = true;
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.closeRealse(statement, connection, query);
		}
		return flag;
	}

	@Override
	public boolean updateTravellerByTraveller(Traveller traveller) {
		boolean flag = false;
		PreparedStatement statement = null;
		ResultSet query = null;
		try {
			connection.setAutoCommit(false);
			String sql = "update ta_psr SET  name=?,SEX = ?,FLT_NUMBER =?,birth = ? where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, traveller.getName());
			statement.setString(2, traveller.getSex());
			statement.setString(3, traveller.getFLT_NUMBER());
			statement.setDate(4, traveller.getBirth());
			statement.setInt(5, traveller.getId());
			connection.commit();
			statement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			SqlUtils.closeRealse(statement, connection, query);
		}
		return flag;
	}

	@Override
	public List<Traveller> getAll() {
		List<Traveller> travellers = new ArrayList<Traveller>();
		try {
			String sql = "select * from ta_psr";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet query = statement.executeQuery();

			while (query.next()) {
				int id = query.getInt(1);
				String name = query.getString(2);
				String sex = query.getString(3);
				Date birth = query.getDate(4);
				String flt_numer = query.getString(5);
				travellers.add(new Traveller(id, name, sex, birth, flt_numer));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return travellers;
	}

}
