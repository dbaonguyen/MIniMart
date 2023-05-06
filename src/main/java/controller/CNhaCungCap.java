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

import dao.INhaccDAO;
import dao.ImplNhaccDAO;
import entity.NhaCungCap;

@Controller
@RequestMapping("/nhacc")
public class CNhaCungCap {
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String index(Model m) {
		List<NhaCungCap> lstncc = loadData();
		m.addAttribute("lst", lstncc);
		
		return "nhacc/index";
	}
	@RequestMapping(value = "/initInsert", method = RequestMethod.GET)
	public String initInsert(Model m) {
		NhaCungCap ncc = new NhaCungCap();
		m.addAttribute("ncc", ncc);
		return "nhacc/insert";
		
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("ncc") NhaCungCap ncc, BindingResult result, Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		
		if (result.hasErrors()) {
			m.addAttribute("ncc", ncc);
			return "nhacc/insert";
		}
		
		boolean isOk = dao.insert(ncc);
		m.addAttribute("ncc", ncc);
		if (isOk) {
			
			m.addAttribute("msg", "Success");
		}
		else {
			m.addAttribute("msgErr", "Failed");
		}
		
		m.addAttribute("ncc", ncc);
		return "nhacc/insert";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "idncc")int idncc, Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		NhaCungCap ncc = dao.selectById(idncc);
		m.addAttribute("ncc", ncc);
		
		return "nhacc/detail";
		
	}
	
	@RequestMapping(value = "init-update", method = RequestMethod.GET)
	public String initUpdate(@RequestParam(name = "idncc")int idncc, Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		NhaCungCap ncc = dao.selectById(idncc);
		m.addAttribute("ncc", ncc);
		
		
		return "nhacc/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("ncc")NhaCungCap ncc,BindingResult result, Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		if (result.hasErrors()) {
			m.addAttribute("ncc", ncc);
			return "nhacc/update";
		}
		
		boolean isOk = dao.update(ncc);
		m.addAttribute("ncc", ncc);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		
		return "nhacc/update";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("idncc")int idncc,Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		boolean isOk = dao.delete(idncc);
		if (!isOk) {
			m.addAttribute("msg", "Success");
		} else {
			m.addAttribute("msgErr", "Failed");
		}
		
		List<NhaCungCap> lstncc = loadData();
		m.addAttribute("lst", lstncc);
		
		return "nhacc/index";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "search") String search, Model m) {
		INhaccDAO dao = new ImplNhaccDAO();
		List<NhaCungCap> lstncc = dao.search(search);
		m.addAttribute("lst", lstncc);
		m.addAttribute("s", search);
		
		return "nhacc/index";
	}
	
	private List<NhaCungCap> loadData(){
		INhaccDAO dao = new ImplNhaccDAO();
		return dao.selectAll();
	}
}
