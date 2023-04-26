package com.storage.dto;

import java.io.Serializable;

public class ThirdPartyDto implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Long id;
    private String partnerName;
    private String city;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
