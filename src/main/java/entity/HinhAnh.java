package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name = "TBL_HINH_ANH_1")
public class HinhAnh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ghichu")
	private String ghichu;
	@Column(name = "stt")
	private int stt;
	@Column(name = "trangthai")
	private Short trangthai;
	
	@Transient
	private MultipartFile anhsanpham;
	

	@Column(name = "anhsanpham")
	private String urlanhsanpham;
	
	@ManyToOne
	@JoinColumn(name = "idsanpham", referencedColumnName = "id")
	private HangHoa hangHoa;
	
	public HinhAnh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public HinhAnh(int id, String ghichu, int stt, Short trangthai, HangHoa hangHoa) {
		super();
		this.id = id;
		this.ghichu = ghichu;
		this.stt = stt;
		this.trangthai = trangthai;
		this.hangHoa = hangHoa;
	}
	
	


	public HinhAnh(String ghichu, int stt, Short trangthai, HangHoa hangHoa) {
		super();
		this.ghichu = ghichu;
		this.stt = stt;
		this.trangthai = trangthai;
		this.hangHoa = hangHoa;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public Short getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Short trangthai) {
		this.trangthai = trangthai;
	}

	public HangHoa getHangHoa() {
		return hangHoa;
	}

	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}



	public MultipartFile getAnhsanpham() {
		return anhsanpham;
	}



	public void setAnhsanpham(MultipartFile anhsanpham) {
		this.anhsanpham = anhsanpham;
	}



	public String getUrlanhsanpham() {
		return urlanhsanpham;
	}



	public void setUrlanhsanpham(String urlanhsanpham) {
		this.urlanhsanpham = urlanhsanpham;
	}
	
	
	
	
}
