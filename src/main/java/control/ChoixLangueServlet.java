package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Locale;

//@WebServlet("/ChoixLangueServlet")
//public class ChoixLangueServlet extends HttpServlet {
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
//        Locale local = request.getLocale();
//
//        //
//        request.setAttribute("langue", local.getLanguage());
//
//
//        RequestDispatcher rd = request.getRequestDispatcher("/acceuil.jsp");
//        rd.forward(request, response);
//
////        String locale = request.getParameter("langue");
////        if (locale != null) {
////            session.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", locale);
////        } else {
////            session.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", "fr_CA");
////        }
////        response.sendRedirect(request.getHeader("Referer"));
//            }

//}

@WebServlet("/ChoixLangueServlet")
public class ChoixLangueServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = request.getParameter("langue");
        if (locale != null) {
            HttpSession session = request.getSession();
            session.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", new Locale(locale));
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    @Override
    public void init() throws ServletException {
        super.init();
        // Set default locale to French
        Locale defaultLocale = new Locale("fr", "CA");
        getServletContext().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", defaultLocale);
    }
}

