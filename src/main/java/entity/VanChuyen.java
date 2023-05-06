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

@Entity
@Table(name = "TBL_VAN_CHUYEN_1")
public class VanChuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "ghichu")
	private String ghichu;
	@Column(name = "trangthai")
	private Short trangthai;
	
	@OneToMany(mappedBy = "vanChuyen", fetch = FetchType.EAGER)
	private List<HoaDon> lsthd;
	
	public VanChuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VanChuyen(int id, String ten, String ghichu, Short trangthai) {
		super();
		this.id = id;
		this.ten = ten;
		this.ghichu = ghichu;
		this.trangthai = trangthai;
	}
	
	
	public VanChuyen(String ten, String ghichu, Short trangthai) {
		super();
		this.ten = ten;
		this.ghichu = ghichu;
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
