package me.action;

import java.util.Calendar;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import me.dto.SampleDTO;

public class SampleAction {
    private String firstName;
    private String lastName;

    public SampleAction() {
        this(null, null);
    }

    public SampleAction(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public final boolean checkParameter(final HttpServletRequest req) {
        String firstName = req.getParameter("FirstName");
        if (firstName == null || "".equals(firstName)) {
            return false;
        }
        
        String lastName = req.getParameter("LastName");
        if (lastName == null || "".equals(lastName)) {
            return false;
        }

        return true;
    }

    public final String execute(final HttpServletRequest req) {
        SampleDTO dto = new SampleDTO(firstName, lastName);

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            dto.setMessage("Good morning");
        } else {
            dto.setMessage("Good afternoon");
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("dto", dto);

        return "./WEB-INF/result.jsp";
    }
}
