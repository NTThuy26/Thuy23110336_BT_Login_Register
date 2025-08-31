package nt.tthuy.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nt.tthuy.Interface.Service.UserService;
import nt.tthuy.Models.User;
import nt.tthuy.Service.Imp.UserServiceImpl;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgot-password")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String FORGOT = "/Views/ForgotPassword.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(FORGOT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        UserService service = new UserServiceImpl();
        String alertMsg = "";

        User user = service.getByEmail(email);
        if (user != null) {
            alertMsg = "Mật khẩu của bạn là: " + user.getPassWord();
        } else {
            alertMsg = "Email không tồn tại!";
        }
        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher(FORGOT).forward(req, resp);
    }
}
