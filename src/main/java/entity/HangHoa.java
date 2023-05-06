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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "TBL_HANG_HOA_1")
public class HangHoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Không được để trống")
	@Size(max = 32, message = "Mã vạch không được quá 32 ký tự")
	@Column(name = "barcode")
	private String barcode;
	@NotEmpty(message = "Không được để trống")
	@Size(max = 128, message = "Tên hàng không được quá 128 ký tự")
	@Column(name = "tenhanghoa")
	private String tenhanghoa;
	@PositiveOrZero(message = "Số lượng không được âm")
	@Column(name = "soluong")
	private float soluong;
	@PositiveOrZero(message = "Giá nhập không được âm")
	@Column(name = "gianhap")
	private float gianhap;
	@PositiveOrZero(message = "Giá xuất không được âm")
	@Column(name = "giaxuat")
	private float giaxuat;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;
	@PastOrPresent(message = "Ngày cập nhật không lớn hơn ngày tạo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaycapnhat")
	private Date ngaycapnhat;
	@Size(max = 128, message = "Ghi chú không được quá 128 ký tự")
	@Column(name = "ghichu")
	private String ghichu;
	
	@NotNull(message = "Không được để trống")
	@ManyToOne
	@JoinColumn(name = "idchungloai", referencedColumnName = "id")
	private ChungLoai chungLoai;
	
	@NotNull(message = "Không được để trống")
	@ManyToOne
	@JoinColumn(name = "idnhacc", referencedColumnName = "id")
	private NhaCungCap nhaCungCap;
	
	@NotNull(message = "Không được để trống")
	@ManyToOne
	@JoinColumn(name = "iddonvitinh", referencedColumnName = "id")
	private DonViTinh donViTinh;
	
	@OneToMany(mappedBy = "hangHoa", fetch = FetchType.LAZY)
	private List<HinhAnh> lstha;
	
	@OneToMany(mappedBy = "hangHoa", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<HoaDonChiTiet> lsthdct;

	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangHoa(int id, String barcode, String tenhanghoa, float soluong, float gianhap, float giaxuat, Date ngaytao,
			Date ngaycapnhat, String ghichu, ChungLoai chungLoai, NhaCungCap nhaCungCap, DonViTinh donViTinh) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.tenhanghoa = tenhanghoa;
		this.soluong = soluong;
		this.gianhap = gianhap;
		this.giaxuat = giaxuat;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.ghichu = ghichu;
		this.chungLoai = chungLoai;
		this.nhaCungCap = nhaCungCap;
		this.donViTinh = donViTinh;
	}

	public HangHoa(String barcode, String tenhanghoa, float soluong, float gianhap, float giaxuat, Date ngaytao,
			Date ngaycapnhat, String ghichu, ChungLoai chungLoai, NhaCungCap nhaCungCap, DonViTinh donViTinh) {
		super();
		this.barcode = barcode;
		this.tenhanghoa = tenhanghoa;
		this.soluong = soluong;
		this.gianhap = gianhap;
		this.giaxuat = giaxuat;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.ghichu = ghichu;
		this.chungLoai = chungLoai;
		this.nhaCungCap = nhaCungCap;
		this.donViTinh = donViTinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getTenhanghoa() {
		return tenhanghoa;
	}

	public void setTenhanghoa(String tenhanghoa) {
		this.tenhanghoa = tenhanghoa;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public float getGianhap() {
		return gianhap;
	}

	public void setGianhap(float gianhap) {
		this.gianhap = gianhap;
	}

	public float getGiaxuat() {
		return giaxuat;
	}

	public void setGiaxuat(float giaxuat) {
		this.giaxuat = giaxuat;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Date getNgaycapnhat() {
		return ngaycapnhat;
	}

	public void setNgaycapnhat(Date ngaycapnhat) {
		this.ngaycapnhat = ngaycapnhat;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public ChungLoai getChungLoai() {
		return chungLoai;
	}

	public void setChungLoai(ChungLoai chungLoai) {
		this.chungLoai = chungLoai;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public DonViTinh getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}

	public List<HinhAnh> getLstha() {
		return lstha;
	}

	public void setLstha(List<HinhAnh> lstha) {
		this.lstha = lstha;
	}

	
	
	
}
