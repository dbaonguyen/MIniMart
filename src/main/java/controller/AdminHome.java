package controller;

import java.util.List;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.IChungLoaiDAO;
import dao.IHangHoaDAO;
import dao.INhaccDAO;
import dao.INhanVienDAO;
import dao.ImplChungLoaiDAO;
import dao.ImplHangHoaDAO;
import dao.ImplNhaccDAO;
import dao.ImplNhanVienDAO;
import entity.HangHoa;


@Controller
@RequestMapping("/home/admin")
public class AdminHome {
	
	@RequestMapping(value = {"/",""})
	public String home(Locale locale ,Model m) {
		
//		ResourceBundle rb = ResourceBundle.getBundle("i18n.resource", locale);
//		String overview = rb.getString("overview");
//		String product_name = rb.getString("label.product.name");
//		m.addAttribute("thongtin", overview);
//		m.addAttribute("product", product_name);
		
		
		
		IChungLoaiDAO dao = new ImplChungLoaiDAO();
	    long sodanhmuc = dao.count();
	    m.addAttribute("sodanhmuc", sodanhmuc);
	    
	    IHangHoaDAO daoHH = new ImplHangHoaDAO();
	    long sohanghoa = daoHH.count();
	    m.addAttribute("sohanghoa", sohanghoa);

	    String spbc = daoHH.sanPhamBanChay();
	    m.addAttribute("spbc", spbc);
	    
	    List<HangHoa> sanphamcannhap = daoHH.sanPhamCanNhap();
	    boolean nullproduct = sanphamcannhap.isEmpty();
	    if (nullproduct) {
			m.addAttribute("nullmsg", "Sản phẩm đã nhập đủ");
		} else {
			m.addAttribute("sanphamcannhap", sanphamcannhap);
		}
	    
	    
	    INhanVienDAO daoNV = new ImplNhanVienDAO();
	    long sonhanvien = daoNV.count();
	    m.addAttribute("sonhanvien", sonhanvien);
	    
	    String nvtc = daoNV.nhanVienTichCuc();
	    m.addAttribute("nvtc", nvtc);
	    
	    INhaccDAO daoNCC = new ImplNhaccDAO();
	    long sonhacc = daoNCC.count();
	    m.addAttribute("sonhacc", sonhacc);
	    
	    String nccbanchay = daoNCC.nhaCungCapBanChayNhat();
	    m.addAttribute("nccbanchay", nccbanchay);
	    
	    daoNV.close();
	    
		return "home/admin/index";
	}
}
