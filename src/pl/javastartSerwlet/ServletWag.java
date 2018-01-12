package pl.javastartSerwlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import pl.javastartConvert.Converter;
import pl.javastartData.Data;
import pl.javastartData.UnitChecker;

@WebServlet("/przelicznikWag")
public class ServletWag extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Data data = createDataFromRequest(request);
        sendResponse(data, response);
    }

    private Data createDataFromRequest(HttpServletRequest request) {

        String kilograms = request.getParameter("kilogramy");
        String grams = request.getParameter("grams");
        String miligrams = request.getParameter("miligramy");

        Data data = new Data();
        UnitChecker unitChecker = new UnitChecker();
        Converter converter = new Converter();
        String unit = unitChecker.getUnitWeightFromRequestParameters(kilograms, grams, miligrams);

        if (unit.equals("kilgr")) {
            data.setMeters(kilograms);
            Double value = Double.valueOf(kilograms);
            data.setCentimeters(Double.toString(converter.metersToCentimeters(value)));
            data.setMilimeters(Double.toString(converter.metersToMilimeters(value)));

        } if (unit.equals("grs")) {
            data.setCentimeters(grams);
            Double value2 = Double.valueOf(grams);
            data.setMeters(Double.toString(converter.centimitersToMeters(value2)));
            data.setMilimeters(Double.toString(converter.centimitersToMilimeters(value2)));

        } if (unit.equals("miligr")) {
            data.setMilimeters(miligrams);
            Double value3 = Double.valueOf(miligrams);
            data.setCentimeters(Double.toString(converter.milimitersToCentimeters(value3)));
            data.setMeters(Double.toString(converter.milimitersToMeters(value3)));
        }
        return data;
    }

    private void sendResponse(Data data, HttpServletResponse response)  throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h1>Podana wartość w przeliczeniu na: </h1>");

        writer.println("metry: " + data.getKilograms() + "<br>");
        writer.println("centymetry: " + data.getGrams() + "<br>");
        writer.println("milimetry: " + data.getMiligrams() + "<br>");

        writer.println("</body>");
        writer.println("</html>");
    }
}



