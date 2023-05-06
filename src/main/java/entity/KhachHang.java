package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import utils.MinDate;

@Entity
@Table(name = "TBL_KHACH_HANG_1")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull(message = "Không được để trống")
	@Size(max = 64, message = "Họ không được quá 64 từ")
	@Column(name = "ho")
	private String ho;
	@NotNull(message = "Không được để trống")
	@Size(max = 64, message = "Tên không được quá 64 từ")
	@Column(name = "ten")
	private String ten;
	@NotNull(message = "Không được để trống")
	@Column(name = "gioitinh")
	private Short gioi_tinh;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaysinh")
	private Date ngay_sinh;
	@NotNull(message = "Không được để trống")
	@Pattern(regexp = "^\\d+$", message = "Không được điền ký tự")
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@Column(name = "dienthoai", unique = true)
	private String dien_thoai;
	@Column(name = "diachi")
	@Size(max = 128, message = "Không được quá 128 từ")
	private String dia_chi;
	@NotNull(message = "Không được để trống")
	@Size(max = 128, message = "Email quá dài")
	@Email(message = "Email phải đúng định dạng")
	@Column(name = "email", unique = true)
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@MinDate(value = "1930-01-01", message = "Ngày tạo phải lớn hơn 1930-01-01")
	@Column(name = "ngaytao")
	private Date ngay_tao;
	@PastOrPresent(message = "Ngày cập nhật không thể lớn hơn ngày tạo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaycapnhat")
	private Date ngay_cap_nhat;
	@NotNull(message = "Không được để trống")
	@Column(name = "trangthai")
	private Short trang_thai;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.EAGER)
	private List<DiemThuong> lstdt;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private List<HoaDon> lsthd;
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int id, String ho, String ten, Short gioi_tinh, Date ngay_sinh, String dien_thoai, String dia_chi,
			String email, Date ngay_tao, Date ngay_cap_nhat, Short trang_thai) {
		super();
		this.id = id;
		this.ho = ho;
		this.ten = ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.dien_thoai = dien_thoai;
		this.dia_chi = dia_chi;
		this.email = email;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.trang_thai = trang_thai;
	}

	public KhachHang(String ho, String ten, Short gioi_tinh, Date ngay_sinh, String dien_thoai, String dia_chi,
			String email, Date ngay_tao, Date ngay_cap_nhat, Short trang_thai) {
		super();
		this.ho = ho;
		this.ten = ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.dien_thoai = dien_thoai;
		this.dia_chi = dia_chi;
		this.email = email;
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.trang_thai = trang_thai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Short getGioi_tinh() {
	    return gioi_tinh;
	}

	public void setGioi_tinh(Short gioi_tinh) {
	    this.gioi_tinh = gioi_tinh;
	}

	public Short getTrang_thai() {
	    return trang_thai;
	}

	public void setTrang_thai(Short trang_thai) {
	    this.trang_thai = trang_thai;
	}


	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getDien_thoai() {
		return dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public Date getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}

	public void setNgay_cap_nhat(Date ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}

	
	
}
