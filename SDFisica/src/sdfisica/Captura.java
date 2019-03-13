package sdfisica;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Captura{
    
    NumberFormat formatarFloat = new DecimalFormat("#.##");

    private float x;
    private float y;
    private float z;

    public Captura(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Captura(){}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString(){
        return                         "X: " + formatarFloat.format(x) +
                "                       Y: " + formatarFloat.format(y) +
                "                       Z: " + formatarFloat.format(z);
    }
}
