package controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IKhachHangDAO;
import dao.ImplKhachHangDAO;
import entity.KhachHang;

@Controller
@RequestMapping("/khachhang/nhanvien")
public class CKhachHangNhanVien {
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model m) {
		List<KhachHang> lstkh = loadData();
		m.addAttribute("lst", lstkh);

		return "khachhang/nhanvien/index";
	}

	@RequestMapping(value = "/initInsert", method = RequestMethod.GET)
	public String initInsert(Model m) {
		KhachHang kh = new KhachHang();
		m.addAttribute("kh", kh);
		return "khachhang/nhanvien/insert";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("kh") KhachHang kh, BindingResult result, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		
		if (result.hasErrors()) {
			m.addAttribute("kh", kh);
			return "khachhang/nhanvien/insert";
		}

		boolean isOk = dao.insert(kh);
		m.addAttribute("kh", kh);
		if (isOk) {

			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");			
		}

		m.addAttribute("kh", kh);
		return "khachhang/nhanvien/insert";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "idkh") int idkh, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		KhachHang kh = dao.selectById(idkh);
		m.addAttribute("kh", kh);

		return "khachhang/detail";

	}

	@RequestMapping(value = "init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "idkh") int idkh, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		KhachHang kh = dao.selectById(idkh);
		m.addAttribute("kh", kh);

		return "khachhang/nhanvien/update";
	}

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(@Valid @ModelAttribute("kh") KhachHang kh, BindingResult result, Model m) {
			IKhachHangDAO dao = new ImplKhachHangDAO();
			if (result.hasErrors()) {
				m.addAttribute("kh", kh);
				return "khachhang/nhanvien/update";
			}
			
			boolean isOk = dao.update(kh);
			m.addAttribute("kh", kh);
			if (!isOk) {
				m.addAttribute("msg", "Success");
			} else {
				m.addAttribute("msgErr", "Failed");
			}
	
			return "khachhang/nhanvien/update";
		}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("idkh") int idkh, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		boolean isOk = dao.delete(idkh);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}

		List<KhachHang> lstkh = loadData();
		m.addAttribute("lst", lstkh);

		return "khachhang/nhanvien/index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		List<KhachHang> lstkh = dao.search(search);
		m.addAttribute("lst", lstkh);
		m.addAttribute("s", search);

		return "khachhang/nhanvien/index";
	}

	private List<KhachHang> loadData() {
		IKhachHangDAO dao = new ImplKhachHangDAO();
		return dao.selectAll();
	}
}
