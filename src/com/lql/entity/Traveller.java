package com.lql.entity;

import java.sql.Date;
/**
 * 对应：ta_psr
 * @author Administrator
 *
 */
public class Traveller {

	private int id;
	private String name;
	private String sex;
	// 生日
	private Date birth;
	// 票号
	private String FLT_NUMBER;


	public Traveller(String name, String sex, Date birth, String fLT_NUMBER) {
		super();
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		FLT_NUMBER = fLT_NUMBER;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getFLT_NUMBER() {
		return FLT_NUMBER;
	}

	public void setFLT_NUMBER(String fLT_NUMBER) {
		FLT_NUMBER = fLT_NUMBER;
	}

	@Override
	public String toString() {
		return "Traveller [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birth=" + birth + ", FLT_NUMBER=" + FLT_NUMBER + "]";
	}


	public Traveller(int id, String name, String sex, Date birth,
			String fLT_NUMBER) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		FLT_NUMBER = fLT_NUMBER;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Traveller() {
	}

}
