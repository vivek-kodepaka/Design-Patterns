package com.kode.Design_Patterns.structural.Flyweight;

import lombok.AllArgsConstructor;

//step1: add all staic data that doesnt change
//intrinsic data
@AllArgsConstructor
public class Bullet {
    String image;
    int bulletSize;
    int bulletRadius;
    BulletType buletType;

}
