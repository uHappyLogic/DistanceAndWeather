/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.geo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Viewport {

@SerializedName("northeast")
@Expose
private Northeast northeast;
@SerializedName("southwest")
@Expose
private Southwest southwest;

public Northeast getNortheast() {
return northeast;
}

public void setNortheast(Northeast northeast) {
this.northeast = northeast;
}

public Southwest getSouthwest() {
return southwest;
}

public void setSouthwest(Southwest southwest) {
this.southwest = southwest;
}

}