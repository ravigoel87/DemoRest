package com.ravi.demorest;

import javax.xml.bind.annotation.XmlRootElement;

/*changed on 12/6/18*/

@XmlRootElement
public class Alien {
	
	private String name;
	private int points;
	private int id;
	
	public String getName() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setName(String name2) {
		// TODO Auto-generated method stub
		
		this.name = name2;
		
	}

	public void setPoints(int points2) {
		// TODO Auto-generated method stub
		
		this.points = points2;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id2) {
		// TODO Auto-generated method stub
		
		this.id = id2;
		
	}

	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	
	
	

}
