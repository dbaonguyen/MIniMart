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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_PHAN_QUYEN_1")
public class PhanQuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tenquyen")
	private String tenquyen;
	@Column(name = "vitri")
	private String vitri;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;
	@Column(name = "ghichu")
	private String ghichu;
	
	@OneToMany(mappedBy = "phanQuyen", fetch = FetchType.EAGER)
	private List<NhanVien> lstNhanVien;
	
	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanQuyen(int id, String tenquyen, String vitri, Date ngaytao, String ghichu) {
		super();
		this.id = id;
		this.tenquyen = tenquyen;
		this.vitri = vitri;
		this.ngaytao = ngaytao;
		this.ghichu = ghichu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenquyen() {
		return tenquyen;
	}
	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}
	public String getVitri() {
		return vitri;
	}
	public void setVitri(String vitri) {
		this.vitri = vitri;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	
}
