/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.geo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

@SerializedName("lat")
@Expose
private double lat;
@SerializedName("lng")
@Expose
private double lng;

public double getLat() {
return lat;
}

public void setLat(double lat) {
this.lat = lat;
}

public double getLng() {
return lng;
}

public void setLng(double lng) {
this.lng = lng;
}

}