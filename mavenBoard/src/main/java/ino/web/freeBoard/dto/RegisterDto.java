package ino.web.freeBoard.dto;

import org.apache.ibatis.type.Alias;

@Alias("registerDto")
public class RegisterDto {
	
	private int no;
	private String name;
	private String pwd;
	private String id;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RegisterDto [no=" + no + ", name=" + name + ", pwd=" + pwd + ", id=" + id + "]";
	}
	
}
