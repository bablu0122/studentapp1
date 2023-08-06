package com.studentapp1.controller;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	//System.out.println(email);
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	service.deleteRegistration(email);
	
	ResultSet result = service.listAllReg();
	request.setAttribute("res", result);
	
	RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
