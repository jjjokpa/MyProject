package com.example.demo.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 
 * @author jjjok
 * ユーザーの情報を扱うドメインクラス
 *
 */
@Entity(name = "User")
@Data
public class UserVO {

	@Id
	public String user_id;
	public String name;
	public int role_id;
	@Temporal(TemporalType.TIMESTAMP)
	public Date last_updated;
	

	public UserVO() {
	}

	public UserVO(String user_id, String name, int role_id, Date last_updated) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.role_id = role_id;
		this.last_updated = last_updated;
	}

}
