package com.help.entity;

import java.util.Objects;

public class Product {
    private int pId;
    private String pName;
    private String pUnit;
    private double pCost;
    private int pQuantity;

    public Product() {
        super();
    }

    public Product(int pId, String pName, String pUnit, double d) {
        super();
        this.pId = pId;
        this.pName = pName;
        this.pUnit = pUnit;
        this.pCost = d;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    public double getpCost() {
        return pCost;
    }

    public void setpCost(double pCost) {
        this.pCost = pCost;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = 29 * hash + Objects.hashCode(this.getpId());
        hash = 29 * hash + Objects.hashCode(this.getpName());
        hash = 29 * hash + Objects.hashCode(this.getpUnit());
        hash = 29 * hash + Objects.hashCode(this.getpCost());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.pName, other.pName)) {
            return false;
        }
        if (!Objects.equals(this.pId, other.pId)) {
            return false;
        }
        if (!Objects.equals(this.pUnit, other.pUnit)) {
            return false;
        }
        if (!Objects.equals(this.pCost, other.pCost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pId=" + pId + ", pName=" + pName + ", pUnit=" + pUnit + ", pCost=" + pCost + ", pQuantity=" + pQuantity;
    }
}
