package com.capgemini.vegetable.model;

public class Vegetable implements Comparable<Vegetable>{
	private int vegid;
	private String vegname;
	private float price;
	
	public Vegetable() {
		super();
	}

	public Vegetable(int vegid, String vegname, float price) {
		super();
		this.vegid = vegid;
		this.vegname = vegname;
		this.price = price;
	}

	public int getVegid() {
		return vegid;
	}

	public void setVegid(int vegid) {
		this.vegid = vegid;
	}

	public String getVegname() {
		return vegname;
	}

	public void setVegname(String vegname) {
		this.vegname = vegname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + vegid;
		result = prime * result + ((vegname == null) ? 0 : vegname.hashCode());
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
		Vegetable other = (Vegetable) obj;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (vegid != other.vegid)
			return false;
		if (vegname == null) {
			if (other.vegname != null)
				return false;
		} else if (!vegname.equals(other.vegname))
			return false;
		return true;
	}

	@Override
	public int compareTo(Vegetable veggi) {
		// TODO Auto-generated method stub
		return vegname.compareTo(veggi.vegname);
	}
	
}
