package com.plotno.plotno.data;

import lombok.Data;

@Data
public class Material {
    public static int lp = 1;
    int id;
    int wysokoscCm;
    double cenaZl;
    int szerokoscCm;

    public Material(int wysokoscCm, double cenaZl) {
        this.cenaZl = cenaZl;
        this.wysokoscCm = wysokoscCm;
        this.id = lp;
        lp++;
    }
}
