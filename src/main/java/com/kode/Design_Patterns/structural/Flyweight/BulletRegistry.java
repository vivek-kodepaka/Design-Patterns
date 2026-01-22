package com.kode.Design_Patterns.structural.Flyweight;

import java.util.HashMap;

public class BulletRegistry {

    HashMap<BulletType,Bullet> bullets = new HashMap<>();

    public void addBullet(Bullet bullet){
        bullets.put(bullet.buletType,bullet);
    }

    public Bullet getBullets(BulletType type){
      return   bullets.get(type);
    }
}
