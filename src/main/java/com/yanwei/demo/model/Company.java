package com.yanwei.demo.model;

import lombok.Data;

@Data
public class Company{

    String entname;

    String uniscid;

    String regno;

    String pripid;

    public Company(String entname, String uniscid, String regno, String pripid) {
        this.entname = entname;
        this.uniscid = uniscid;
        this.regno = regno;
        this.pripid = pripid;
    }
}
