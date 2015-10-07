import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ���� on 06.10.2015.
 */
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String k = calculate(request.getParameter("number1"), request.getParameter("number2"), request.getParameter("operation"));
        request.setAttribute("result", k);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    String calculate(String chislo1, String chislo2, String operatoin) {
        float result = 0;
        try {
            float n1 = new Float(chislo1);
            float n2 = new Float(chislo2);
            switch (operatoin.charAt(0)) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '/':
                    result = n1 / n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
            }
            return Float.toString(result);
        } catch (NumberFormatException e) {
            return "Введено не число";
        }
        catch (ArithmeticException e){
            return "Деление на 0 запрещено";
        }
    }

}

