package com.javaeeeee.dwstart.core;

public class IndicadorCircular {
	private String label;
	private Float value;
	
	public IndicadorCircular(String label, Float value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
}
