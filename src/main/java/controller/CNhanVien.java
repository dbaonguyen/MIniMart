package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IKhachHangDAO;
import dao.INhanVienDAO;
import dao.IPhanQuyenDAO;
import dao.ImplKhachHangDAO;
import dao.ImplNhanVienDAO;
import dao.ImplPhanQuyenDAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhanQuyen;

@Controller
@RequestMapping("/nhanvien")
public class CNhanVien {
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model m) {
		List<NhanVien> lstnv = loadData();
		m.addAttribute("lst", lstnv);

		return "nhanvien/index";
	}

	@RequestMapping(value = "/bangluong", method = RequestMethod.GET)
	public String bangluong(Model m) {
		List<NhanVien> lstnv = loadData();
		m.addAttribute("lst", lstnv);

		return "nhanvien/bangluong";
	}

	@RequestMapping(value = "/initInsert", method = RequestMethod.GET)
	public String initInsert(Model m) {
		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		NhanVien nv = new NhanVien();
		m.addAttribute("nv", nv);

		return "nhanvien/insert";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("nv") NhanVien nv, BindingResult result, Model m) {
		INhanVienDAO dao = new ImplNhanVienDAO();
		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		if (result.hasErrors()) {
			List<PhanQuyen> lstpq = daoPQ.selectAll();
			m.addAttribute("nv", nv);
			m.addAttribute("lstpq", lstpq);
			return "nhanvien/insert";
		}

		boolean isOk = dao.insert(nv);
		m.addAttribute("nv", nv);
		if (isOk) {

			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}

		m.addAttribute("nv", nv);

		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		return "nhanvien/insert";

	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "idnv") int idnv, Model m) {

		INhanVienDAO dao = new ImplNhanVienDAO();
		NhanVien nv = dao.selectById(idnv);
		m.addAttribute("nv", nv);

		return "nhanvien/detail";
	}

	@RequestMapping(value = "init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "idnv") int idnv, Model m) {
		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		INhanVienDAO dao = new ImplNhanVienDAO();
		NhanVien nv = dao.selectById(idnv);
		m.addAttribute("nv", nv);

		return "nhanvien/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("nv") NhanVien nv, BindingResult result, Model m) {
		INhanVienDAO dao = new ImplNhanVienDAO();

		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		if (result.hasErrors()) {
			List<PhanQuyen> lstpq = daoPQ.selectAll();
			m.addAttribute("lstpq", lstpq);
			m.addAttribute("nv", nv);
			return "nhanvien/update";
		}

		boolean isOk = dao.update(nv);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		m.addAttribute("nv", nv);
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		return "nhanvien/update";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("idnv") int idnv, Model m) {
		INhanVienDAO dao = new ImplNhanVienDAO();
		boolean isOk = dao.delete(idnv);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		List<NhanVien> lstnv = loadData();
		m.addAttribute("lst", lstnv);
		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		return "nhanvien/index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		INhanVienDAO dao = new ImplNhanVienDAO();
		List<NhanVien> lstnv = dao.search(search);
		m.addAttribute("lst", lstnv);
		m.addAttribute("s", search);

		return "nhanvien/index";

	}

	@RequestMapping(value = "/accountdetail", method = RequestMethod.GET)
	public String accdetail(@RequestParam(name = "idnv") int idnv, Model m) {

		INhanVienDAO dao = new ImplNhanVienDAO();
		NhanVien nv = dao.accDetail(idnv);
		m.addAttribute("nv", nv);

		return "nhanvien/accountdetail";
	}

	@RequestMapping(value = "init-update-account", method = RequestMethod.GET)
	public String initUpdateAccount(@RequestParam(name = "idnv") int idnv, Model m) {
		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		INhanVienDAO dao = new ImplNhanVienDAO();
		NhanVien nv = dao.selectById(idnv);
		m.addAttribute("nv", nv);

		

		return "nhanvien/updateaccount";
	}

	@RequestMapping(value = "/updateaccount", method = RequestMethod.POST)
	public String updateAccount(@Valid @ModelAttribute("nv") NhanVien nv, BindingResult result, Model m) {
		INhanVienDAO dao = new ImplNhanVienDAO();

		IPhanQuyenDAO daoPQ = new ImplPhanQuyenDAO();
		if (result.hasErrors()) {
			List<PhanQuyen> lstpq = daoPQ.selectAll();
			m.addAttribute("lstpq", lstpq);
			m.addAttribute("nv", nv);
			return "nhanvien/updateaccount";
		}

		boolean isOk = dao.update(nv);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		m.addAttribute("nv", nv);
		List<PhanQuyen> lstpq = daoPQ.selectAll();
		m.addAttribute("lstpq", lstpq);

		return "nhanvien/updateaccount";
	}

	private List<NhanVien> loadData() {
		INhanVienDAO dao = new ImplNhanVienDAO();
		return dao.selectAll();
	}
}
