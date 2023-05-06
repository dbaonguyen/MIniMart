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

import dao.IHoaDonDAO;
import dao.IKhachHangDAO;

import dao.INhanVienDAO;
import dao.IThanhToanDAO;
import dao.IVanChuyenDAO;

import dao.ImplHoaDonDAO;
import dao.ImplKhachHangDAO;
import dao.ImplNhanVienDAO;
import dao.ImplThanhToanDAO;
import dao.ImplVanChuyenDAO;
import entity.ChungLoai;
import entity.DonViTinh;

import entity.HoaDon;
import entity.KhachHang;

import entity.NhanVien;
import entity.ThanhToan;
import entity.VanChuyen;

@Controller
@RequestMapping("/hoadon/admin")
public class CHoaDonAdmin {

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model m) {
		List<HoaDon> lsthd = loadData();
		m.addAttribute("lst", lsthd);
		
		return "hoadon/admin/index";
	}
	
	@RequestMapping(value = "/init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "idhd") int idhd, Model m) {
		IVanChuyenDAO daoVC = new ImplVanChuyenDAO();
		List<VanChuyen> lstvc = daoVC.selectAll();
		m.addAttribute("lstvc", lstvc);

		IThanhToanDAO daoTT = new ImplThanhToanDAO();
		List<ThanhToan> lsttt = daoTT.selectAll();
		m.addAttribute("lsttt", lsttt);

		IKhachHangDAO daoKH = new ImplKhachHangDAO();
		List<KhachHang> lstkh = daoKH.selectAll();
		m.addAttribute("lstkh", lstkh);
		
		INhanVienDAO daoNV = new ImplNhanVienDAO();
		List<NhanVien> lstnv = daoNV.selectAll();
		m.addAttribute("lstnv", lstnv);
		
		
		IHoaDonDAO dao = new ImplHoaDonDAO();
		HoaDon hd = dao.selectById(idhd);
		m.addAttribute("hd", hd);

		return "hoadon/admin/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("hd") HoaDon hd,BindingResult result, Model m) {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		IVanChuyenDAO daoVC = new ImplVanChuyenDAO();
		IThanhToanDAO daoTT = new ImplThanhToanDAO();
		IKhachHangDAO daoKH = new ImplKhachHangDAO();
		INhanVienDAO daoNV = new ImplNhanVienDAO();
		System.out.println("Chạy xong impl");
		if (result.hasErrors()) {
			System.out.println("Chạy vào đây rồi");
			m.addAttribute("hd", hd);
			List<VanChuyen> lstvc = daoVC.selectAll();
			m.addAttribute("lstvc", lstvc);
			List<ThanhToan> lsttt = daoTT.selectAll();
			m.addAttribute("lsttt", lsttt);
			List<KhachHang> lstkh = daoKH.selectAll();
			m.addAttribute("lstkh", lstkh);
			List<NhanVien> lstnv = daoNV.selectAll();
			m.addAttribute("lstnv", lstnv);
			
			return "hoadon/admin/update";
		}
		
		
		
		boolean isOk = dao.update(hd);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		m.addAttribute("hd", hd);

		List<VanChuyen> lstvc = daoVC.selectAll();
		m.addAttribute("lstvc", lstvc);
		List<ThanhToan> lsttt = daoTT.selectAll();
		m.addAttribute("lsttt", lsttt);
		List<KhachHang> lstkh = daoKH.selectAll();
		m.addAttribute("lstkh", lstkh);
		List<NhanVien> lstnv = daoNV.selectAll();
		m.addAttribute("lstnv", lstnv);

		return "hoadon/admin/update";

	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		List<HoaDon> lsthh = dao.search(search);
		m.addAttribute("lst", lsthh);
		m.addAttribute("s", search);
		
		return "hoadon/admin/index";
	}
	
	

	private List<HoaDon> loadData() {
		IHoaDonDAO dao = new ImplHoaDonDAO();
		return dao.selectAll();
	}
}
