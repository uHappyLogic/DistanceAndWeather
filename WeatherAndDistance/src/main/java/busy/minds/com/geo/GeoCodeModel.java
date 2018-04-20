/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com.geo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoCodeModel {

@SerializedName("results")
@Expose
private List<Result> results = null;
@SerializedName("status")
@Expose
private String status;

public List<Result> getResults() {
return results;
}

public void setResults(List<Result> results) {
this.results = results;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}
