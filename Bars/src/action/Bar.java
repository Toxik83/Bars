package action;
//���� � ������,�����  ��  �������� ��  �����������  ��  �������,��������� �� ���-��������.//
//������������ ����������  Serializable, ����� ���������  ������� �� ��  �������� � �����
//�� ����-�����.������ ��� ���������� ��������������.�� �� �������� ������� ���� ����������� ��.//
//���������� �� � ����� � ������ �� ������ private, �� ��  ��  ������ ���� � �����//

import java.io.Serializable;

public class Bar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private int bar_id;
     private String name;
     private int places;
     private int price;
     private String time;
	private String category;
	private String address;
	public int getBar_id() {
		return bar_id;
	}
	public void setBar_id(int bar_id) {
		this.bar_id = bar_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlaces() {
		return places;
	}
	public void setPlaces(int places) {
		this.places = places;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	

}
