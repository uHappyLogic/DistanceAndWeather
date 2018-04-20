/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.geo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry {

@SerializedName("location")
@Expose
private Location location;
@SerializedName("location_type")
@Expose
private String locationType;
@SerializedName("viewport")
@Expose
private Viewport viewport;

public Location getLocation() {
return location;
}

public void setLocation(Location location) {
this.location = location;
}

public String getLocationType() {
return locationType;
}

public void setLocationType(String locationType) {
this.locationType = locationType;
}

public Viewport getViewport() {
return viewport;
}

public void setViewport(Viewport viewport) {
this.viewport = viewport;
}

}
