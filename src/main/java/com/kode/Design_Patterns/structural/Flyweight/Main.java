package com.kode.Design_Patterns.structural.Flyweight;

public class Main {
    public static void main(String[] args) {
        Tree mangoTree = TreeFactory.getTree("mango");
        mangoTree.draw("mango",10,15);
        Tree mangoTree1 = TreeFactory.getTree("mango");
        mangoTree1.draw("mango",12,20);
        Tree AppleTree = TreeFactory.getTree("apple");
        mangoTree1.draw("apple",19,13);
        System.out.println("mangoTree1==mangoTree ?" + (mangoTree1==mangoTree));



        Bullet bullet = new Bullet("img1",2,2,BulletType.ELEVEN_MM);
        Bullet bullet2 = new Bullet("img2",3,2,BulletType.Nine_MM);
        BulletRegistry bulletRegistry = new BulletRegistry();
        bulletRegistry.addBullet(bullet);
        bulletRegistry.addBullet(bullet2);

        FlyingBullet flyingBullet = new FlyingBullet(1,2,3,2.0,bulletRegistry.getBullets(BulletType.Nine_MM));
        FlyingBullet flyingBullet2 = new FlyingBullet(2,3,4,2.0,bulletRegistry.getBullets(BulletType.ELEVEN_MM));
    }
}
