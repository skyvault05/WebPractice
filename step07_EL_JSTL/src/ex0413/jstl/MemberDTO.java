package ex0413.jstl;

public class MemberDTO {
	private String id;
	private int age;
	private String addr;
	private String phone;
	
	public MemberDTO() {};
	public MemberDTO(String id, int age, String addr, String phone) {
		super();
		this.id = id;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	public String getPhone() {
		return phone;
	}
	
	
	
}
