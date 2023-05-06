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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_NHA_CUNG_CAP_1")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Size(max = 128, message = "Tên nhà cung cấp không được quá 128 ký tự")
	@NotEmpty(message = "Không được để trống")
	@Column(name = "tennhacc")
	private String tennhacc;

	@Size(max = 128, message = "Địa chỉ không được quá 128 ký tự")
	@NotEmpty(message = "Không được để trống")
	@Column(name = "diachi")
	private String diachi;

	@Pattern(regexp = "^\\d*$", message = "Số điện thoại phải đúng định dạng")
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@NotEmpty(message = "Không được để trống")
	@Column(name = "sdt1")
	private String sdt1;
	@Pattern(regexp = "^\\d*$", message = "Số điện thoại phải đúng định dạng")
	@Size(max = 11, message = "Số điện thoại không được quá 11 số")
	@Column(name = "sdt2")
	private String sdt2;
	@Size(max = 16, message = "Không được quá 16 ký tự")
	@Column(name = "fax")
	private String fax;
	@Email(message = "Email phải đúng định dạng")
	@Size(max = 256, message = "Email không được quá 256 ký tự")
	@Column(name = "email", unique = true)
	private String email;
	@Size(max = 256, message = "Tên miền không được quá 256 ký tự")
	@Column(name = "website", unique = true)
	private String website;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaycapnhat")
	private Date ngaycapnhat;
	@Size(max = 64, message = "Tax code không được quá 64 ký tự")
	@Column(name = "taxcode")
	private String taxcode;
	@Size(max = 256, message = "Ghi chú không được quá 256 ký tự")
	@Column(name = "ghichu")
	private String ghichu;
	@Column(name = "trangthai")
	private Short trangthai;

	@OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.EAGER)
	private List<HangHoa> lsthh;

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(int id, String tennhacc, String diachi, String sdt1, String sdt2, String fax, String email,
			String website, Date ngaytao, Date ngaycapnhat, String taxcode, String ghichu, Short trangthai) {
		super();
		this.id = id;
		this.tennhacc = tennhacc;
		this.diachi = diachi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.taxcode = taxcode;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
	}

	public NhaCungCap(String tennhacc, String diachi, String sdt1, String sdt2, String fax, String email,
			String website, Date ngaytao, Date ngaycapnhat, String taxcode, String ghichu, Short trangthai
			) {
		super();
		this.tennhacc = tennhacc;
		this.diachi = diachi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.taxcode = taxcode;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTennhacc() {
		return tennhacc;
	}

	public void setTennhacc(String tennhacc) {
		this.tennhacc = tennhacc;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt1() {
		return sdt1;
	}

	public void setSdt1(String sdt1) {
		this.sdt1 = sdt1;
	}

	public String getSdt2() {
		return sdt2;
	}

	public void setSdt2(String sdt2) {
		this.sdt2 = sdt2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
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

}
