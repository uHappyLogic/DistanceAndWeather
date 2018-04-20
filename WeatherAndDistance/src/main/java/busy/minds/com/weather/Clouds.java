/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

@SerializedName("all")
@Expose
private int all;

public int getAll() {
return all;
}

public void setAll(int all) {
this.all = all;
}

}