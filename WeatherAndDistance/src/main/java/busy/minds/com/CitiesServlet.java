package busy.minds.com;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CitiesServlet", urlPatterns = {"/cities/ajax"})
public class CitiesServlet extends HttpServlet {

    public static final String GET_CITIES = "getCities";
    
    public static final String COMMAND_PARAMETER = "command";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String command = request.getParameter(COMMAND_PARAMETER);
        
        if (command == null)
            throw  new ServletException("Command parameter not found");
        
        switch (command) {
            case GET_CITIES: processGetCities(response); break;
                
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
}
