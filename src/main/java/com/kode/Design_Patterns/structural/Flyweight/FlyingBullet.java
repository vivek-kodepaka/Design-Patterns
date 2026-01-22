package com.kode.Design_Patterns.structural.Flyweight;

import lombok.AllArgsConstructor;

//step2:extrinsic data
@AllArgsConstructor
public class FlyingBullet {
    int x,y,z;
    Double direction;

    //step3: add a has a relation of intinsic state

    Bullet bullet;

}
