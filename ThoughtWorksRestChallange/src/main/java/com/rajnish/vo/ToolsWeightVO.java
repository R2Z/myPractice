package com.rajnish.vo;

import java.util.Comparator;

public class ToolsWeightVO implements Comparable<ToolsWeightVO> {

	private String name;
	private int weight;
	private int value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "ToolsWeightVO [name=" + name + ", weight=" + weight
				+ ", value=" + value + "]";
	}
	@Override
	public int compareTo(ToolsWeightVO o) {
		int val = 0;
		
		if(this.getName().compareTo(o.getName()) > 0){
			val = 1;
		}else if (this.getName().compareTo(o.getName()) < 0){
			val = -1;
		}
		return val;
	}
	
}
