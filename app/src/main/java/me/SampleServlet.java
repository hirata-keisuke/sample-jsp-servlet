package me;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import me.action.SampleAction;

public class SampleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected final void doGet(
        final HttpServletRequest req, final HttpServletResponse res
    ) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String path = "./WEB-INF/error.jsp";

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, res);
    }

    protected final void doPost(
        final HttpServletRequest req, final HttpServletResponse res
    ) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String path = "./WEB-INF/error.jsp";

        String actionName = req.getParameter("action");

        if (actionName != null) {
            SampleAction action = createAction(actionName);
            if (action != null) {
                if (action.checkParameter(req)) {
                    path = action.execute(req);
                }
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, res);
    }

    private SampleAction createAction(final String actionName) {
        if ("hello".equals(actionName)) {
            return new SampleAction();
        } else {
            return null;
        }
    }

}