package com.cn.entity;
/**
 * 商品类
 * @author Administrator
 *
 */
public class Commodity {
	private int id;//商品id
	private String name;//商品名称
	private int oldPrice;//商品原来的价钱
	private int newPrice;//商品最新价钱
	private String description;//商品描述
	private String imgURL;//商品图片路径
	private int num;//商品数量
	
	
	public Commodity(String name, int oldPrice, int newPrice,
			String description, String imgURL, int num) {
		super();
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.description = description;
		this.imgURL = imgURL;
		this.num = num;
	}
	public Commodity(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", oldPrice="
				+ oldPrice + ", newPrice=" + newPrice + ", description="
				+ description + ", imgURL=" + imgURL + ", num=" + num + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((imgURL == null) ? 0 : imgURL.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + newPrice;
		result = prime * result + num;
		result = prime * result + oldPrice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (imgURL == null) {
			if (other.imgURL != null)
				return false;
		} else if (!imgURL.equals(other.imgURL))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newPrice != other.newPrice)
			return false;
		if (num != other.num)
			return false;
		if (oldPrice != other.oldPrice)
			return false;
		return true;
	}
	public Commodity() {
		super();
	}
	
	public Commodity(int id, String name, int oldPrice, int newPrice,
			String description, String imgURL, int num) {
		super();
		this.id = id;
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.description = description;
		this.imgURL = imgURL;
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}
	public int getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
