package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBL_CUA_HANG_1")
public class CuaHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tencuahang")
	private String tencuahang;
	@Column(name = "diachi")
	private String diachi;
	@Column(name = "sdt1")
	private String sdt1;
	@Column(name = "sdt2")
	private String sdt2;
	@Column(name = "giomocua")
	private int giomocua;
	@Column(name = "giodongcua")
	private int giodongcua;
	@Column(name = "ghichu")
	private String ghichu;
	
	@Transient
	@OneToMany(mappedBy = "cuaHang",fetch = FetchType.EAGER)
	private List<NhanVien> lstnv;

	public CuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuaHang(int id, String tencuahang, String diachi, String sdt1, String sdt2, int giomocua, int giodongcua,
			String ghichu) {
		super();
		this.id = id;
		this.tencuahang = tencuahang;
		this.diachi = diachi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.giomocua = giomocua;
		this.giodongcua = giodongcua;
		this.ghichu = ghichu;

	}

	public CuaHang(String tencuahang, String diachi, String sdt1, String sdt2, int giomocua, int giodongcua,
			String ghichu) {
		super();
		this.tencuahang = tencuahang;
		this.diachi = diachi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.giomocua = giomocua;
		this.giodongcua = giodongcua;
		this.ghichu = ghichu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTencuahang() {
		return tencuahang;
	}

	public void setTencuahang(String tencuahang) {
		this.tencuahang = tencuahang;
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

	public int getGiomocua() {
		return giomocua;
	}

	public void setGiomocua(int giomocua) {
		this.giomocua = giomocua;
	}

	public int getGiodongcua() {
		return giodongcua;
	}

	public void setGiodongcua(int giodongcua) {
		this.giodongcua = giodongcua;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	
	
	
	
}
