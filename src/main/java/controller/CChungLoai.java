package controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import dao.IChungLoaiDAO;
import dao.ImplChungLoaiDAO;
import entity.ChungLoai;

@Controller
@RequestMapping("/chungloai")
public class CChungLoai {
	
	
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String initInsert(Model m) {
		ChungLoai cl = new ChungLoai();
		m.addAttribute("cl", cl);
		
		IChungLoaiDAO dao = new ImplChungLoaiDAO();
		
		
		return "chungloai/index";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("cl") ChungLoai cl, BindingResult result, HttpServletRequest request,
			Model m) {
		IChungLoaiDAO dao = new ImplChungLoaiDAO();

		if (!result.hasErrors()) {
			// valid dữ liệu file
			if (cl.getAnhminhhoa() != null) {// Bắt đầu upload file
				// Lấy đường dẫn root gốc
//				String rootPath = request.getServletContext().getRealPath("/public/images");
				String rootPath = request.getServletContext().getRealPath("/");
				System.out.println("Rootpath: " + rootPath);
				File rootFile = new File(rootPath);
				File parentFolder = rootFile.getParentFile();
				File fileDestination = new File(parentFolder.getAbsolutePath() + File.separator + "/public_resource");

				MultipartFile fileImage = cl.getAnhminhhoa();
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
	            cl.setUrlanhminhhoa("/public_resource/" + filename);
			}
			boolean isOk = dao.insert(cl);
			m.addAttribute("cl", cl);
			if (isOk) {

				m.addAttribute("msg", "Thêm mới thành công");
			} else {
				m.addAttribute("msgErr", "Thất bại");
			}
			m.addAttribute("msgS", "Thanh cong");
		}

		m.addAttribute("cl", cl);

		return "chungloai/index";
	}
	
	


}
