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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import utils.MinDate;

@Entity
@Table(name = "TBL_NHAN_VIEN_1")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Không được để trống")
	@Size(max = 64, message = "Tên không được quá 64 ký tự")
	@Column(name = "hovaten")
	private String hovaten;
	@NotNull(message = "Không được để trống")
	@Column(name = "gioitinh")
	private Short gioitinh;
	@NotNull(message = "Không được để trống")
	@Column(name = "ngaysinh")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	@Column(name = "ngayvaolam")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayvaolam;
	@Column(name = "ngaycapnhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaycapnhat;
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@NotNull(message = "Không được để trống")
	@Pattern(regexp = "^\\d*$", message = "Số điện thoại phải đúng định dạng")
	@Column(name = "didong", unique = true)
	private String didong;
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@Pattern(regexp = "^\\d*$", message = "Số điện thoại phải đúng định dạng")
	@Column(name = "dtgiadinh", nullable = true)
	private String dtgiadinh;
	@Email(message = "Email phải đúng định dạng")
	@Size(max = 128, message = "Email không được quá 128 ký tự")
	@Column(name = "email")
	private String email;
	@Size(max = 128, message = "Địa chỉ không được quá 128 ký tự")
	@Column(name = "diachi")
	private String diachi;
	@Max(value = 1000000000, message = "Lương cơ bản không được quá cao")
	@PositiveOrZero(message = "Lương cơ bản không được để âm")
	@Column(name = "luongcoban")
	private float luongcoban;
	@Size(max = 64, message = "Tên đăng nhập không được quá 64 ký tự")
	@NotNull(message = "Tên đăng nhập không được để trống")
	@Column(name = "username", unique = true)
	private String username;
	@NotNull(message = "Không được để trống")
	@NotEmpty(message = "Không được để trống")
	@Size(max = 64, message = "Mật khẩu không được quá 64 ký tự")
	@Column(name = "password")
	private String password;
	@Size(max = 256, message = "Ghi chú không được quá dài")
	@Column(name = "ghichu")
	private String ghichu;
	@NotNull(message = "Không được để trống")
	@Column(name = "trangthai")
	private Short trangthai;

	@ManyToOne
	@JoinColumn(name = "idphanquyen", referencedColumnName = "id")
	private PhanQuyen phanQuyen;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.EAGER)
	private List<HoaDon> lsthd;
	
	@Transient
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private CuaHang cuaHang;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int id, String hovaten, Short gioitinh, Date ngaysinh, Date ngayvaolam, Date ngaycapnhat,
			String didong, String dtgiadinh, String email, String diachi, float luongcoban, String username,
			String password, String ghichu, Short trangthai, PhanQuyen phanQuyen) {
		super();
		this.id = id;
		this.hovaten = hovaten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.ngayvaolam = ngayvaolam;
		this.ngaycapnhat = ngaycapnhat;
		this.didong = didong;
		this.dtgiadinh = dtgiadinh;
		this.email = email;
		this.diachi = diachi;
		this.luongcoban = luongcoban;
		this.username = username;
		this.password = password;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
		this.phanQuyen = phanQuyen;
	}

	public NhanVien(String hovaten, Short gioitinh, Date ngaysinh, Date ngayvaolam, Date ngaycapnhat, String didong,
			String dtgiadinh, String email, String diachi, float luongcoban, String username, String password,
			String ghichu, Short trangthai, PhanQuyen phanQuyen) {
		super();
		this.hovaten = hovaten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.ngayvaolam = ngayvaolam;
		this.ngaycapnhat = ngaycapnhat;
		this.didong = didong;
		this.dtgiadinh = dtgiadinh;
		this.email = email;
		this.diachi = diachi;
		this.luongcoban = luongcoban;
		this.username = username;
		this.password = password;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
		this.phanQuyen = phanQuyen;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public Short getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(Short gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Date getNgayvaolam() {
		return ngayvaolam;
	}

	public void setNgayvaolam(Date ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}

	public Date getNgaycapnhat() {
		return ngaycapnhat;
	}

	public void setNgaycapnhat(Date ngaycapnhat) {
		this.ngaycapnhat = ngaycapnhat;
	}

	public String getDidong() {
		return didong;
	}

	public void setDidong(String didong) {
		this.didong = didong;
	}

	public String getDtgiadinh() {
		return dtgiadinh;
	}

	public void setDtgiadinh(String dtgiadinh) {
		this.dtgiadinh = dtgiadinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getLuongcoban() {
		return luongcoban;
	}

	public void setLuongcoban(float luongcoban) {
		this.luongcoban = luongcoban;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Short getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Short trangthai) {
		this.trangthai = trangthai;
	}

	public PhanQuyen getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(PhanQuyen phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

}
