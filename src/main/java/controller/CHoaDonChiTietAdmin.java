package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IHoaDonChiTietDAO;
import dao.ImplHoaDonChiTietDAO;
import entity.HoaDonChiTiet;

@Controller
@RequestMapping("/hoadon/admin/hoadonchitiet")
public class CHoaDonChiTietAdmin {

	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String detail(@RequestParam int idhd, Model model) {
	    IHoaDonChiTietDAO dao = new ImplHoaDonChiTietDAO();
	    List<Object[]> results = dao.selectById(idhd);
	    model.addAttribute("results", results);
	    return "hoadon/admin/hoadonchitiet/index";
	}

}
