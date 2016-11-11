package model;

import java.util.Date;

public class Person {
	private Integer age;
	private Date birth;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", birth=" + birth + "]";
	}
	
}
