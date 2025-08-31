package nt.tthuy.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nt.tthuy.Interface.Service.UserService;
import nt.tthuy.Service.Imp.UserServiceImpl;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String REGISTER = "/Views/register.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }

        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }

        // Nếu chưa login thì mở form đăng ký
        req.getRequestDispatcher(REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        UserService service = new UserServiceImpl();
        String alertMsg = "";

        // Validate
        if (username == null || username.isEmpty() ||
            password == null || password.isEmpty() ||
            email == null || email.isEmpty() ||
            phone == null || phone.isEmpty()) {
            alertMsg = "Vui lòng nhập đầy đủ thông tin!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        if (service.checkExistUsername(username)) {
            alertMsg = "Tên đăng nhập đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        if (service.checkExistPhone(phone)) {
            alertMsg = "Số điện thoại đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        // Insert user
        boolean isSuccess = service.register(email, password, username, phone);

        if (isSuccess) {
            req.getSession().setAttribute("success", "Đăng ký thành công, hãy đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
        }

    }
}
