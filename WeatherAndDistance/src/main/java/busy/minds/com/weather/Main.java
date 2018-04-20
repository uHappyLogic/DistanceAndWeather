/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

@SerializedName("temp")
@Expose
private double temp;
@SerializedName("pressure")
@Expose
private int pressure;
@SerializedName("humidity")
@Expose
private int humidity;
@SerializedName("temp_min")
@Expose
private double tempMin;
@SerializedName("temp_max")
@Expose
private double tempMax;

public double getTemp() {
return temp;
}

public void setTemp(double temp) {
this.temp = temp;
}

public int getPressure() {
return pressure;
}

public void setPressure(int pressure) {
this.pressure = pressure;
}

public int getHumidity() {
return humidity;
}

public void setHumidity(int humidity) {
this.humidity = humidity;
}

public double getTempMin() {
return tempMin;
}

public void setTempMin(double tempMin) {
this.tempMin = tempMin;
}

public double getTempMax() {
return tempMax;
}

public void setTempMax(double tempMax) {
this.tempMax = tempMax;
}

}