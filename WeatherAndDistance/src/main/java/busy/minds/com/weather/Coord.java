/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord {

@SerializedName("lon")
@Expose
private double lon;
@SerializedName("lat")
@Expose
private double lat;

public double getLon() {
return lon;
}

public void setLon(double lon) {
this.lon = lon;
}

public double getLat() {
return lat;
}

public void setLat(double lat) {
this.lat = lat;
}

}