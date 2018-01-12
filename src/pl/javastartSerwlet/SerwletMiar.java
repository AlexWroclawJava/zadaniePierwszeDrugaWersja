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

@WebServlet("/przelicznikMiar")
public class SerwletMiar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Data data = createDataFromRequest(request);
        sendResponse(data, response);
    }

    private Data createDataFromRequest(HttpServletRequest request) {

        String meters = request.getParameter("metry");
        String centimeters = request.getParameter("centymetry");
        String milimeters = request.getParameter("milimetry");

        Data data = new Data();
        UnitChecker unitChecker = new UnitChecker();
        Converter converter = new Converter();
        String unit = unitChecker.getUnitMeasureFromRequestParameters(meters, centimeters, milimeters);

        if (unit.equals("metr")) {
            data.setMeters(meters);
            Double value = Double.valueOf(meters);
            data.setCentimeters(Double.toString(converter.metersToCentimeters(value)));
            data.setMilimeters(Double.toString(converter.metersToMilimeters(value)));

        } if (unit.equals("centr")) {
            data.setCentimeters(centimeters);
            Double value2 = Double.valueOf(centimeters);
            data.setMeters(Double.toString(converter.centimitersToMeters(value2)));
            data.setMilimeters(Double.toString(converter.centimitersToMilimeters(value2)));

        } if (unit.equals("milr")) {
            data.setMilimeters(milimeters);
            Double value3 = Double.valueOf(milimeters);
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

        writer.println("metry: " + data.getMeters() + "<br>");
        writer.println("centymetry: " + data.getCentimeters() + "<br>");
        writer.println("milimetry: " + data.getMilimeters() + "<br>");

            writer.println("</body>");
        writer.println("</html>");
    }
}