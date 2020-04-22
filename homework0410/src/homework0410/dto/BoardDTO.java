package homework0410.dto;

import java.util.Date;

public class BoardDTO {
	private String name;
	private String content;
	private Date date;
	
	
	
	public BoardDTO(String name, String content, String date) {
		super();
		this.name = name;
		this.content = content;
		this.date = new Date(Long.parseLong(date)) ;
	}
	public BoardDTO(String name, String content, Date date) {
		this.name = name;
		this.content = content;
		this.date = date;	
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
