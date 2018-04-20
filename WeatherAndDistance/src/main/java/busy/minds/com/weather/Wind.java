/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

@SerializedName("speed")
@Expose
private double speed;
@SerializedName("deg")
@Expose
private int deg;

public double getSpeed() {
return speed;
}

public void setSpeed(double speed) {
this.speed = speed;
}

public int getDeg() {
return deg;
}

public void setDeg(int deg) {
this.deg = deg;
}

}