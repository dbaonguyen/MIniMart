package controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.IHangHoaDAO;
import dao.IHinhAnhDAO;
import dao.ImplHangHoaDAO;
import dao.ImplHinhAnhDAO;
import entity.HangHoa;
import entity.HinhAnh;

@Controller
@RequestMapping("/hinhanh")
public class CHinhAnh {
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String initInsert(Model m) {
		IHangHoaDAO daoHH = new ImplHangHoaDAO();
		List<HangHoa> lsthh = daoHH.selectAll();
		m.addAttribute("lsthh", lsthh);
		
		HinhAnh ha = new HinhAnh();
		m.addAttribute("ha", ha);
		
		
		return "hinhanh/index";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("ha") HinhAnh ha, BindingResult result, HttpServletRequest request,
			Model m) {
		IHangHoaDAO daoHH = new ImplHangHoaDAO();
		IHinhAnhDAO dao = new ImplHinhAnhDAO();
		System.out.println("Chạy vào dao");
		if (result.hasErrors()) {
			System.out.println("Chạy vào đây");
		}
		
		if (!result.hasErrors()) {
			System.out.println("Chạy vào đây");
			// valid dữ liệu file
			if (ha.getAnhsanpham() != null) {// Bắt đầu upload file
				// Lấy đường dẫn root gốc
				
//				String rootPath = request.getServletContext().getRealPath("/public/images");
				String rootPath = request.getServletContext().getRealPath("/");
				System.out.println("Rootpath: " + rootPath);
				File rootFile = new File(rootPath);
				File parentFolder = rootFile.getParentFile();
				File fileDestination = new File(parentFolder.getAbsolutePath() + File.separator + "/public_resource");

				MultipartFile fileImage = ha.getAnhsanpham();
				String filename = fileImage.getOriginalFilename();
				System.out.println("Filename: " + filename);

				// Kiểm tra xem file đã tồn tại chưa
				File fileupload = new File(fileDestination.getAbsolutePath() + File.separator + filename);
				if (!fileupload.exists()) {
					byte data[];
					try {
						data = fileImage.getBytes();
						Files.write(fileupload.toPath(), data, StandardOpenOption.CREATE_NEW);
						System.out.println("Ghi file ảnh thành công");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
	            ha.setUrlanhsanpham("/public_resource/" + filename);
			}
			boolean isOk = dao.insert(ha);
			m.addAttribute("ha", ha);
			if (isOk) {

				m.addAttribute("msg", "Thêm mới thành công");
			} else {
				m.addAttribute("msgErr", "Thất bại");
			}
			m.addAttribute("msgS", "Thanh cong");
		}
		m.addAttribute("ha", ha);
		List<HangHoa> lsthh = daoHH.selectAll();
		m.addAttribute("lsthh", lsthh);
		
		

		return "hinhanh/index";
	}
}
