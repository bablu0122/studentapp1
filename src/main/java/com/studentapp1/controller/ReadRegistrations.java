package com.studentapp1.controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.studentapp1.model.DAOService;
import com.studentapp1.model.DAOServiceImpl;

@WebServlet("/listAll")
public class ReadRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadRegistrations() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	ResultSet result = service.listAllReg();
	request.setAttribute("res", result);
	
	RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
