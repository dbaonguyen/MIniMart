package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IDiemThuongDAO;
import dao.ImplDiemThuongDAO;
import entity.DiemThuong;
import entity.NhanVien;


@Controller
@RequestMapping("/diemthuong/admin")
public class CDiemThuongAdmin {
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String index(Model m) {
	    IDiemThuongDAO dao = new ImplDiemThuongDAO();
	    List<Object[]> results = dao.selectAll();
	    m.addAttribute("lst", results);
	    return "diemthuong/admin/index";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "ten", required = false) String ten, Model m) {
	    IDiemThuongDAO dao = new ImplDiemThuongDAO();
	    List<Object[]> results;
	    if (ten != null && !ten.isEmpty()) {
	        results = dao.searchByTen(ten);
	    } else {
	        results = dao.selectAll();
	    }
	    m.addAttribute("lst", results);
	    return "diemthuong/admin/index";
	}
}
