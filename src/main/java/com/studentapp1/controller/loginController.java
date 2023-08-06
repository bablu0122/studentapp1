package com.studentapp1.controller;


@WebServlet("/verifylogin")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DAOService service =new DAOServiceImpl();
        service.connectDB();
        boolean status = service.verifylogin(email, password);
        if(status) {
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
        	rd.forward(request, response);
        	//System.out.println("welcome");
        }else {
        	//System.out.println("Invalid username/password");
        	request.setAttribute("error", "Invalid username/password");
        	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        	rd.forward(request, response);
        }
        
	}

}
