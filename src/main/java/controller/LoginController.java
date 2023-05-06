package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.INhanVienDAO;
import dao.ImplNhanVienDAO;
import entity.NhanVien;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String showLoginForm() {
	    
	    return "login";
	}

	
	    
	@RequestMapping(value = {"","/"}, method = RequestMethod.POST)
	public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session, 
	                            Model model) {
	    INhanVienDAO dao = new ImplNhanVienDAO();
	    NhanVien nv = dao.getEmployeeByUsername(username, password);
	    if (nv != null && nv.getPassword().equals(password)) {
	        session.setAttribute("loggedInUser", nv.getHovaten());
	        session.setAttribute("loggedInUsername", nv.getUsername());
	        session.setAttribute("loggedInId", nv.getId());
	        
	        // Check the role of the user and redirect accordingly
	        if (nv.getPhanQuyen().getTenquyen().equals("Admin")) {
	        	if(nv.getTrangthai() == 1) {
	        		return "redirect:/home/admin";
	        	} else {
	        		model.addAttribute("error", "Tài khoản đã bị khóa");
	        		return "login";
	        	}
	            
	        } else {
	        	if(nv.getTrangthai() == 1) {
	        		return "redirect:/home/nhanvien";
	        	} else {
	        		model.addAttribute("error", "Tài khoản đã bị khóa");
	        		return "login";
	        	}
	            
	        }
	    } else {
	            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
	            return "login";
	        
	    }   
	}






}
