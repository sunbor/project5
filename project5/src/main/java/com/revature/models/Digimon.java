package com.revature.models;

public class Digimon {
	
	private int digiId;
	private String name;
	private String type;
	private String evolution;
	public int getDigiId() {
		return digiId;
	}
	public void setDigiId(int digiId) {
		this.digiId = digiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEvolution() {
		return evolution;
	}
	public void setEvolution(String evolution) {
		this.evolution = evolution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + digiId;
		result = prime * result + ((evolution == null) ? 0 : evolution.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Digimon other = (Digimon) obj;
		if (digiId != other.digiId)
			return false;
		if (evolution == null) {
			if (other.evolution != null)
				return false;
		} else if (!evolution.equals(other.evolution))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Digimon [digiId=" + digiId + ", name=" + name + ", type=" + type + ", evolution=" + evolution + "]";
	}
	public Digimon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Digimon(int digiId, String name, String type, String evolution) {
		super();
		this.digiId = digiId;
		this.name = name;
		this.type = type;
		this.evolution = evolution;
	}

}
