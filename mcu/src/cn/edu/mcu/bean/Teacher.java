package cn.edu.mcu.bean;

import javax.persistence.*;

@Entity
@Table(name = "mcu_teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "icon")
	private String icon;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "account_id")
	private Integer accountId;

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
}
