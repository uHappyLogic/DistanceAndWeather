/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.dist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

@SerializedName("elements")
@Expose
private List<Element> elements = null;

public List<Element> getElements() {
return elements;
}

public void setElements(List<Element> elements) {
this.elements = elements;
}

}