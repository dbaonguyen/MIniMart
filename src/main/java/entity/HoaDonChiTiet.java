package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@IdClass(PKHoaDonChiTiet.class)
@Table(name = "TBL_HOADON_CHI_TIET_1")
public class HoaDonChiTiet {
	@Id
	@ManyToOne
	@JoinColumn(name = "idhoadon", referencedColumnName = "id")
	private HoaDon hoaDon;

	@Id
	@ManyToOne
	@JoinColumn(name = "idhanghoa", referencedColumnName = "id")
	private HangHoa hangHoa;

	@Column(name = "soluong")
	private float soluong;

	@Column(name = "gia")
	private float gia;
	
	public HoaDonChiTiet() {
		// TODO Auto-generated constructor stub
	}

	public HoaDonChiTiet(HoaDon hoaDon, HangHoa hangHoa, float soluong, float gia) {
		super();
		this.hoaDon = hoaDon;
		this.hangHoa = hangHoa;
		this.soluong = soluong;
		this.gia = gia;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public HangHoa getHangHoa() {
		return hangHoa;
	}

	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}
	

	
}
