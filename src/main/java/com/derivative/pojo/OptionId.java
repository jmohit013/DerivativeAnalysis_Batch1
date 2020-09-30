package com.derivative.pojo;

import java.io.Serializable;

public class OptionId implements Serializable {

	private String companyName;
	private String optionsCategory;
	private String optionsType;
	private String underlyingAsset;
	
	public OptionId() {
		// TODO Auto-generated constructor stub
	}

	public OptionId(String companyName, String optionsCategory, String optionsType, String underlyingAsset) {
		super();
		this.companyName = companyName;
		this.optionsCategory = optionsCategory;
		this.optionsType = optionsType;
		this.underlyingAsset = underlyingAsset;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOptionsCategory() {
		return optionsCategory;
	}

	public void setOptionsCategory(String optionsCategory) {
		this.optionsCategory = optionsCategory;
	}

	public String getOptionsType() {
		return optionsType;
	}

	public void setOptionsType(String optionsType) {
		this.optionsType = optionsType;
	}

	public String getUnderlyingAsset() {
		return underlyingAsset;
	}

	public void setUnderlyingAsset(String underlyingAsset) {
		this.underlyingAsset = underlyingAsset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((optionsCategory == null) ? 0 : optionsCategory.hashCode());
		result = prime * result + ((optionsType == null) ? 0 : optionsType.hashCode());
		result = prime * result + ((underlyingAsset == null) ? 0 : underlyingAsset.hashCode());
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
		OptionId other = (OptionId) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (optionsCategory == null) {
			if (other.optionsCategory != null)
				return false;
		} else if (!optionsCategory.equals(other.optionsCategory))
			return false;
		if (optionsType == null) {
			if (other.optionsType != null)
				return false;
		} else if (!optionsType.equals(other.optionsType))
			return false;
		if (underlyingAsset == null) {
			if (other.underlyingAsset != null)
				return false;
		} else if (!underlyingAsset.equals(other.underlyingAsset))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OptionId [companyName=" + companyName + ", optionsCategory=" + optionsCategory + ", optionsType="
				+ optionsType + ", underlyingAsset=" + underlyingAsset + "]";
	}
	
	
	
}