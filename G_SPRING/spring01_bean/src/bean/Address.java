package bean;

public class Address {

	private String name;
	private String address;
	private String phone;
	
	public Address() {
		System.out.println("매개변수가 없는 생성자로 Address 인스턴스 생성");
	}

	public Address(String name, String address, String phone) {
		super();
		System.out.println("매개변수가 있는 생성자로 Address 인스턴스 생성");
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName : "+ name);
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("setAddress : "+ address);
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println("setPhone : "+ phone);
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
