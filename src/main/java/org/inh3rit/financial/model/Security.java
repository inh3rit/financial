package org.inh3rit.financial.model;

public class Security {
    private String securityCode;

    private String securityNameAbbr;

    private String tradeMarketCode;

    private String tradeMarket;

    private String securityTypeCode;

    private String securityType;

    private String publishName;

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode == null ? null : securityCode.trim();
    }

    public String getSecurityNameAbbr() {
        return securityNameAbbr;
    }

    public void setSecurityNameAbbr(String securityNameAbbr) {
        this.securityNameAbbr = securityNameAbbr == null ? null : securityNameAbbr.trim();
    }

    public String getTradeMarketCode() {
        return tradeMarketCode;
    }

    public void setTradeMarketCode(String tradeMarketCode) {
        this.tradeMarketCode = tradeMarketCode == null ? null : tradeMarketCode.trim();
    }

    public String getTradeMarket() {
        return tradeMarket;
    }

    public void setTradeMarket(String tradeMarket) {
        this.tradeMarket = tradeMarket == null ? null : tradeMarket.trim();
    }

    public String getSecurityTypeCode() {
        return securityTypeCode;
    }

    public void setSecurityTypeCode(String securityTypeCode) {
        this.securityTypeCode = securityTypeCode == null ? null : securityTypeCode.trim();
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType == null ? null : securityType.trim();
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName == null ? null : publishName.trim();
    }
}