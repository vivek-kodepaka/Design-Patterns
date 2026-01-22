package com.kode.Design_Patterns.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postion {
   private int x;
    private int y;
    private int z;

    public Postion(Postion postion){
        this.x=postion.getX();
        this.y=postion.getY();
        this.z=postion.getZ();
    }
}
