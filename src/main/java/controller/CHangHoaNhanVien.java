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

import dao.IChungLoaiDAO;
import dao.IDonViTinhDAO;
import dao.IHangHoaDAO;
import dao.INhaccDAO;
import dao.ImplChungLoaiDAO;
import dao.ImplDonViTinhDAO;
import dao.ImplHangHoaDAO;
import dao.ImplNhaccDAO;
import entity.ChungLoai;
import entity.DonViTinh;
import entity.HangHoa;
import entity.NhaCungCap;

@Controller
@RequestMapping("/hanghoa/nhanvien")
public class CHangHoaNhanVien {

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model m) {
		List<HangHoa> lsthh = loadData();
		m.addAttribute("lst", lsthh);

		return "hanghoa/nhanvien/index";
	}

	@RequestMapping(value = "/initInsert", method = RequestMethod.GET)
	public String initInsert(Model m) {
		IDonViTinhDAO daoDVT = new ImplDonViTinhDAO();
		List<DonViTinh> lstdvt = daoDVT.selectAll();
		m.addAttribute("lstdvt", lstdvt);

		IChungLoaiDAO daoCL = new ImplChungLoaiDAO();
		List<ChungLoai> lstcl = daoCL.selectAll();
		m.addAttribute("lstcl", lstcl);

		INhaccDAO daoNCC = new ImplNhaccDAO();
		List<NhaCungCap> lstncc = daoNCC.selectAll();
		m.addAttribute("lstncc", lstncc);

		HangHoa hh = new HangHoa();
		m.addAttribute("hh", hh);

		return "hanghoa/nhanvien/insert";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("hh") HangHoa hh, BindingResult result, Model m) {
		IDonViTinhDAO daoDVT = new ImplDonViTinhDAO();
		IChungLoaiDAO daoCL = new ImplChungLoaiDAO();
		INhaccDAO daoNCC = new ImplNhaccDAO();
		IHangHoaDAO dao = new ImplHangHoaDAO();
		if (result.hasErrors()) {
			List<DonViTinh> lstdvt = daoDVT.selectAll();
			List<ChungLoai> lstcl = daoCL.selectAll();
			List<NhaCungCap> lstncc = daoNCC.selectAll();
			m.addAttribute("hh", hh);
			m.addAttribute("lstcl", lstcl);
			m.addAttribute("lstdvt", lstdvt);
			m.addAttribute("lstncc", lstncc);
			return "hanghoa/nhanvien/insert";
		}

		boolean isOk = dao.insert(hh);
		m.addAttribute("hh", hh);
		if (isOk) {

			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}

		m.addAttribute("hh", hh);

		List<DonViTinh> lstdvt = daoDVT.selectAll();
		m.addAttribute("lstdvt", lstdvt);
		List<ChungLoai> lstcl = daoCL.selectAll();
		m.addAttribute("lstcl", lstcl);
		List<NhaCungCap> lstncc = daoNCC.selectAll();
		m.addAttribute("lstncc", lstncc);

		return "hanghoa/nhanvien/insert";

	}
	
	@RequestMapping(value = "init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "idhh")int idhh,Model m) {
		
		IChungLoaiDAO daoCL = new ImplChungLoaiDAO();
		List<ChungLoai> lstcl = daoCL.selectAll();
		m.addAttribute("lstcl", lstcl);
		
		IDonViTinhDAO daoDVT = new ImplDonViTinhDAO();
		List<DonViTinh> lstdvt = daoDVT.selectAll();
		m.addAttribute("lstdvt", lstdvt);
		
		INhaccDAO daoNCC = new ImplNhaccDAO();
		List<NhaCungCap> lstncc = daoNCC.selectAll();
		m.addAttribute("lstncc", lstncc);
		
		IHangHoaDAO dao = new ImplHangHoaDAO();
		HangHoa hh = dao.selectById(idhh);
		m.addAttribute("hh", hh);
		
		return "hanghoa/nhanvien/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("hh")HangHoa hh, BindingResult result, Model m) {
		IHangHoaDAO dao = new ImplHangHoaDAO();
		INhaccDAO daoNCC = new ImplNhaccDAO();
		IDonViTinhDAO daoDVT = new ImplDonViTinhDAO();
		IChungLoaiDAO daoCL = new ImplChungLoaiDAO();
		
		if (result.hasErrors()) {
			List<NhaCungCap> lstncc = daoNCC.selectAll();
			m.addAttribute("lstncc", lstncc);
			List<ChungLoai> lstcl = daoCL.selectAll();
			m.addAttribute("lstcl", lstcl);
			List<DonViTinh> lstdvt = daoDVT.selectAll();
			m.addAttribute("lstdvt", lstdvt);
			
			return "hanghoa/nhanvien/update";
		}
		
		m.addAttribute("hh", hh);
		boolean isOk = dao.update(hh);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		List<NhaCungCap> lstncc = daoNCC.selectAll();
		m.addAttribute("lstncc", lstncc);
		List<ChungLoai> lstcl = daoCL.selectAll();
		m.addAttribute("lstcl", lstcl);
		List<DonViTinh> lstdvt = daoDVT.selectAll();
		m.addAttribute("lstdvt", lstdvt);
		
		return "hanghoa/nhanvien/update";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "idhh") int idhh, Model m) {

		IHangHoaDAO dao = new ImplHangHoaDAO();
		HangHoa hh = dao.selectById(idhh);
		m.addAttribute("hh", hh);

		return "hanghoa/detail";
	}

	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("idhh") int idhh, Model m) {
		IHangHoaDAO dao = new ImplHangHoaDAO();
		boolean isOk = dao.delete(idhh);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		List<HangHoa> lsthh = loadData();
		m.addAttribute("lst", lsthh);
		IChungLoaiDAO daoCL = new ImplChungLoaiDAO();
		List<ChungLoai> lstcl = daoCL.selectAll();
		m.addAttribute("lstcl", lstcl);
		INhaccDAO daoNCC = new ImplNhaccDAO();
		List<NhaCungCap> lstncc = daoNCC.selectAll();
		m.addAttribute("lstncc", lstncc);
		IDonViTinhDAO daoDVT = new ImplDonViTinhDAO();
		List<DonViTinh> lstdvt = daoDVT.selectAll();

		m.addAttribute("lstdvt", lstdvt);

		return "hanghoa/nhanvien/index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		IHangHoaDAO dao = new ImplHangHoaDAO();
		List<HangHoa> lsthh = dao.search(search);
		m.addAttribute("lst", lsthh);
		m.addAttribute("s", search);

		return "hanghoa/nhanvien/index";

	}
	
	

	private List<HangHoa> loadData() {
		IHangHoaDAO dao = new ImplHangHoaDAO();
		return dao.selectAll();
	}
}
