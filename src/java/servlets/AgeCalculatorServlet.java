package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String birthday = "";
        String userAge = request.getParameter("age");

        if (userAge == null || userAge == "") {

            birthday = "You must give your current age";
        } else {
            try {
                
              int newBirthday = Integer.parseInt(userAge);
              newBirthday = newBirthday + 1;
              birthday = "Your age next birthday will be " + newBirthday;
              
            } catch (Exception e) {
                birthday = "You must enter a number";
            }
        }

        request.setAttribute("result", birthday);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

    }

}
