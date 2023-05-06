package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "TBL_CHUNG_LOAI_1")
public class ChungLoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ten")
	private String ten;

	@Column(name = "mota")
	private String mota;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaycapnhat")
	private Date ngaycapnhat;

	@Column(name = "trangthai")
	private Short trangthai;

	@Transient
	private MultipartFile anhminhhoa;

	@Column(name = "anhminhhoa")
	private String urlanhminhhoa;

	@OneToMany(mappedBy = "chungLoai", fetch = FetchType.EAGER)
	private List<HangHoa> lsthh;

	public ChungLoai() {
		super();
	}

	public ChungLoai(String ten, String mota, Date ngaytao, Date ngaycapnhat, Short trangthai) {
		super();
		this.ten = ten;
		this.mota = mota;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.trangthai = trangthai;

	}

	public ChungLoai(int id, String ten, String mota, Date ngaytao, Date ngaycapnhat, Short trangthai) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
		this.ngaytao = ngaytao;
		this.ngaycapnhat = ngaycapnhat;
		this.trangthai = trangthai;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public void setTrangthai(Short trangthai) {
		this.trangthai = trangthai;
	}

	public MultipartFile getAnhminhhoa() {
		return anhminhhoa;
	}

	public void setAnhminhhoa(MultipartFile anhminhhoa) {
		this.anhminhhoa = anhminhhoa;
	}

	public Short getTrangthai() {
		return trangthai;
	}
	public String getUrlanhminhhoa() {
		return urlanhminhhoa;
	}

	public void setUrlanhminhhoa(String urlanhminhhoa) {
		this.urlanhminhhoa = urlanhminhhoa;
	}

}
