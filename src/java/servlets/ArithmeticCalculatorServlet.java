package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstValue = request.getParameter("first");
        String secondValue = request.getParameter("last");
        String operation = request.getParameter("operation");
        int result = 0;
        String badInput = "Invalid";

        request.setAttribute("firstInput", firstValue);
        request.setAttribute("lastInput", secondValue);
        request.setAttribute("result", "---");

        try {

            int first = Integer.parseInt(firstValue);
            int last = Integer.parseInt(secondValue);

            switch (operation) {

                case "+":
                    result = first + last;
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                    break;

                case "-":
                    result = first - last;
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                    break;

                case "*":
                    result = first * last;
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                    break;

                case "%":
                    result = first / last;
                    request.setAttribute("result", result);
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {

            request.setAttribute("result", badInput);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

        }

    }

}
