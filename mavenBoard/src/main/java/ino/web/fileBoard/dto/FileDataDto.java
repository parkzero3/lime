package ino.web.fileBoard.dto;

import org.apache.ibatis.type.Alias;

@Alias("fileDataDto")
public class FileDataDto {

	private int num;
	private int boardnum;
	private String oriname;
	private String chgname;
	private String regdate;
	private int usage;
	
	public FileDataDto(){}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getOriname() {
		return oriname;
	}

	public void setOriname(String oriname) {
		this.oriname = oriname;
	}

	public String getChgname() {
		return chgname;
	}

	public void setChgname(String chgname) {
		this.chgname = chgname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		return "FileDataDto [num=" + num + ", boardnum=" + boardnum + ", oriname=" + oriname + ", chgname=" + chgname
				+ ", regdate=" + regdate + ", usage=" + usage + "]";
	}
	
}
