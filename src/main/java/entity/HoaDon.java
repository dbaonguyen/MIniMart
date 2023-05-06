package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_HOA_DON_2")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@PastOrPresent(message = "Không được quá ngày hiện tại")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaygiaohang")
	private Date ngaygiaohang;
	@Column(name = "trangthai")
	private Short trangthai;
	@NotEmpty(message = "Không được để trống")
	@Size(max = 128, message = "Ghi chú không được quá dài")
	@Column(name = "diachinhan")
	private String diachinhan;
	@NotEmpty(message = "Không được để trống")
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@Pattern(regexp = "^\\d*$", message = "Số điện thoại phải đúng định dạng")
	@Column(name = "sdtnhan")
	private String sdtnhan;
	@Size(max = 128, message = "Ghi chú không được quá dài")
	@Column(name = "ghichu")
	private String ghichu;
	

	@ManyToOne
	@JoinColumn(name = "idvanchuyen", referencedColumnName = "id")
	private VanChuyen vanChuyen;
	

	@ManyToOne
	@JoinColumn(name = "idthanhtoan", referencedColumnName = "id")
	private ThanhToan thanhToan;
	

	@ManyToOne
	@JoinColumn(name = "idkhachhang", referencedColumnName = "id")
	private KhachHang khachHang;

	@ManyToOne
	@JoinColumn(name = "idnhanvien", referencedColumnName = "id")
	private NhanVien nhanVien;
	
	
	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<HoaDonChiTiet> lsthdct;


	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HoaDon(int id, Date ngaytao, Date ngaygiaohang, Short trangthai, String diachinhan, String sdtnhan,
			String ghichu, VanChuyen vanChuyen, ThanhToan thanhToan, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.id = id;
		this.ngaytao = ngaytao;
		this.ngaygiaohang = ngaygiaohang;
		this.trangthai = trangthai;
		this.diachinhan = diachinhan;
		this.sdtnhan = sdtnhan;
		this.ghichu = ghichu;
		this.vanChuyen = vanChuyen;
		this.thanhToan = thanhToan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}



	public HoaDon(Date ngaytao, Date ngaygiaohang, Short trangthai, String diachinhan, String sdtnhan, String ghichu,
			VanChuyen vanChuyen, ThanhToan thanhToan, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.ngaytao = ngaytao;
		this.ngaygiaohang = ngaygiaohang;
		this.trangthai = trangthai;
		this.diachinhan = diachinhan;
		this.sdtnhan = sdtnhan;
		this.ghichu = ghichu;
		this.vanChuyen = vanChuyen;
		this.thanhToan = thanhToan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getNgaytao() {
		return ngaytao;
	}



	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}



	public Date getNgaygiaohang() {
		return ngaygiaohang;
	}



	public void setNgaygiaohang(Date ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}



	public Short getTrangthai() {
		return trangthai;
	}



	public void setTrangthai(Short trangthai) {
		this.trangthai = trangthai;
	}



	public String getDiachinhan() {
		return diachinhan;
	}



	public void setDiachinhan(String diachinhan) {
		this.diachinhan = diachinhan;
	}



	public String getSdtnhan() {
		return sdtnhan;
	}



	public void setSdtnhan(String sdtnhan) {
		this.sdtnhan = sdtnhan;
	}



	public String getGhichu() {
		return ghichu;
	}



	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}



	public VanChuyen getVanChuyen() {
		return vanChuyen;
	}



	public void setVanChuyen(VanChuyen vanChuyen) {
		this.vanChuyen = vanChuyen;
	}



	public ThanhToan getThanhToan() {
		return thanhToan;
	}



	public void setThanhToan(ThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}



	public KhachHang getKhachHang() {
		return khachHang;
	}



	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}



	public NhanVien getNhanVien() {
		return nhanVien;
	}



	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	
	
}
