/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.dist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Duration {

@SerializedName("text")
@Expose
private String text;
@SerializedName("value")
@Expose
private int value;

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public int getValue() {
return value;
}

public void setValue(int value) {
this.value = value;
}

}