package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_DIEM_THUONG_1")
public class DiemThuong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "noidung")
	private String noidung;
	@Positive(message = "Không được âm")
	@Column(name = "diem")
	private int diem;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngaytao")
	private Date ngaytao;
	
	@ManyToOne
	@JoinColumn(name = "idkhachhang",referencedColumnName = "id")
	private KhachHang khachHang;
	
	public DiemThuong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiemThuong(int id, String noidung, int diem, Date ngaytao, KhachHang khachHang) {
		super();
		this.id = id;
		this.noidung = noidung;
		this.diem = diem;
		this.ngaytao = ngaytao;
		this.khachHang = khachHang;
	}

	public DiemThuong(String noidung, int diem, Date ngaytao, KhachHang khachHang) {
		super();
		this.noidung = noidung;
		this.diem = diem;
		this.ngaytao = ngaytao;
		this.khachHang = khachHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	
	
	
	
}
