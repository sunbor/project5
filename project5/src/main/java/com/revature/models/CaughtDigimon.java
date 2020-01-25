package com.revature.models;

public class CaughtDigimon {
	    
    private int digidexId;
    private String digimonName;
    private String imgUrl;
    private String digimonLevel;
    private int userId;
	public CaughtDigimon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaughtDigimon(int digidexId, String digimonName, String imgUrl, String digimonLevel, int userId) {
		super();
		this.digidexId = digidexId;
		this.digimonName = digimonName;
		this.imgUrl = imgUrl;
		this.digimonLevel = digimonLevel;
		this.userId = userId;
	}
	public int getDigidexId() {
		return digidexId;
	}
	public void setDigidexId(int digidexId) {
		this.digidexId = digidexId;
	}
	public String getDigimonName() {
		return digimonName;
	}
	public void setDigimonName(String digimonName) {
		this.digimonName = digimonName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDigimonLevel() {
		return digimonLevel;
	}
	public void setDigimonLevel(String digimonLevel) {
		this.digimonLevel = digimonLevel;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + digidexId;
		result = prime * result + ((digimonLevel == null) ? 0 : digimonLevel.hashCode());
		result = prime * result + ((digimonName == null) ? 0 : digimonName.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + userId;
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
		CaughtDigimon other = (CaughtDigimon) obj;
		if (digidexId != other.digidexId)
			return false;
		if (digimonLevel == null) {
			if (other.digimonLevel != null)
				return false;
		} else if (!digimonLevel.equals(other.digimonLevel))
			return false;
		if (digimonName == null) {
			if (other.digimonName != null)
				return false;
		} else if (!digimonName.equals(other.digimonName))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CaughtDigimon [digidexId=" + digidexId + ", digimonName=" + digimonName + ", imgUrl=" + imgUrl
				+ ", digimonLevel=" + digimonLevel + ", userId=" + userId + "]";
	}
    
    

}
