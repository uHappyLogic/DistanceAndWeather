package busy.minds.com;

import busy.minds.com.dist.DistansModel;
import busy.minds.com.geo.GeoCodeModel;
import busy.minds.com.geo.Location;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CitiesServlet", urlPatterns = {"/cities/ajax"})
public class CitiesServlet extends HttpServlet {

    public static final String GET_CITIES = "get_cities";
    public static final String GET_INFO = "get_info";
    
    public static final String COMMAND_PARAMETER = "command";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String command = request.getParameter(COMMAND_PARAMETER);
        
        if (command == null)
            throw  new ServletException("Command parameter not found");
        
        switch (command) {
            case GET_CITIES: processGetCities(response); break;
            case GET_INFO: processGetInfo(request, response); break;
                
            default: throw new ServletException(String.format("Commnad %s not recognized", command));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Cities ajax servlet";
    }
    
    private void processGetCities(HttpServletResponse response) throws IOException {
        String citiesJson = new Gson().toJson(CitiesContext.getCities());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(citiesJson);
    }
    
    private void processGetInfo(HttpServletRequest request, HttpServletResponse response) throws RuntimeException, IOException {
        try
        {
            String cityName = request.getParameter("city_name");

            DistansModel model = new RestCallHandler().getDistanceJson(cityName);
            GeoCodeModel coords = new RestCallHandler().getCoords(cityName);

            String distance = model.getRows().get(0).getElements().get(0).getDistance().getText();

            Location location = coords.getResults().get(0).getGeometry().getLocation();
            String locationField = String.format("%s,%s", String.valueOf(location.getLat()), String.valueOf(location.getLng()));


            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            JsonObject json = new JsonObject();
            json.addProperty("distance", distance);
            json.addProperty("location", locationField);
            
            String jsonResponse = new Gson().toJson(json);
            
            response.getWriter().write(jsonResponse);
        }catch(Exception e) {
            response.getWriter().write(e.getMessage());
        }
    }
}
