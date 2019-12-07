package day06;

public class HandPhone {
	String productName;
	String productType;
	int price;
	int phoneNumber;
	
	public HandPhone()
	{
		this.productName = "none";
		this.productType = "none";
		this.price = 0;
		this.phoneNumber = 0;
	}
	
	public HandPhone(String productName, String productType, int price, int phoneNum)
	{
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.phoneNumber = phoneNum;
	}
	
	public HandPhone(HandPhone hp)
	{
		this.productName = hp.productName;
		this.productType = hp.productType;
		this.price = hp.price;
		this.phoneNumber = hp.phoneNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
