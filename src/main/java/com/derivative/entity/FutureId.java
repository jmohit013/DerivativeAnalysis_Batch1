package com.derivative.entity;

import java.io.Serializable;

public class FutureId implements Serializable {

	private String companyName;
	private String underlyingAsset;
	private String futuresCategory;

	public FutureId() {
		// TODO Auto-generated constructor stub
	}
	
	public FutureId(String companyName, String underlyingAsset, String futuresCategory) {
		super();
		this.companyName = companyName;
		this.underlyingAsset = underlyingAsset;
		this.futuresCategory = futuresCategory;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUnderlyingAsset() {
		return underlyingAsset;
	}

	public void setUnderlyingAsset(String underlyingAsset) {
		this.underlyingAsset = underlyingAsset;
	}

	public String getFuturesCategory() {
		return futuresCategory;
	}

	public void setFuturesCategory(String futuresCategory) {
		this.futuresCategory = futuresCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((futuresCategory == null) ? 0 : futuresCategory.hashCode());
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
		FutureId other = (FutureId) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (futuresCategory == null) {
			if (other.futuresCategory != null)
				return false;
		} else if (!futuresCategory.equals(other.futuresCategory))
			return false;
		if (underlyingAsset == null) {
			if (other.underlyingAsset != null)
				return false;
		} else if (!underlyingAsset.equals(other.underlyingAsset))
			return false;
		return true;
	}

}
