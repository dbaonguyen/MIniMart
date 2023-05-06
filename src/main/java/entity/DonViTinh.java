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
@Table(name = "TBL_DON_VI_TINH_1")
public class DonViTinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tendonvi")
	private String tendonvi;
	@Column(name = "ghichu")
	private String ghichu;
	
	@OneToMany(mappedBy = "donViTinh", fetch = FetchType.EAGER)
	private List<HangHoa> lsthh;
	
	public DonViTinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonViTinh(int id, String tendonvi, String ghichu) {
		super();
		this.id = id;
		this.tendonvi = tendonvi;
		this.ghichu = ghichu;
	}
	
	public DonViTinh(String tendonvi, String ghichu) {
		super();
		this.tendonvi = tendonvi;
		this.ghichu = ghichu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTendonvi() {
		return tendonvi;
	}
	public void setTendonvi(String tendonvi) {
		this.tendonvi = tendonvi;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	
}
