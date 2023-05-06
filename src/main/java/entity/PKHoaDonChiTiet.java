package entity;

import java.io.Serializable;
import java.util.Objects;

public class PKHoaDonChiTiet implements Serializable {

	private Integer hoaDon;
    private Integer hangHoa;

    public PKHoaDonChiTiet() {}

    public PKHoaDonChiTiet(Integer hoaDon, Integer hangHoa) {
        this.hoaDon = hoaDon;
        this.hangHoa = hangHoa;
    }

	public Integer getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(Integer hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Integer getHangHoa() {
		return hangHoa;
	}

	public void setHangHoa(Integer hangHoa) {
		this.hangHoa = hangHoa;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof PKHoaDonChiTiet)) return false;
	    PKHoaDonChiTiet that = (PKHoaDonChiTiet) obj;
	    return Objects.equals(getHoaDon(), that.getHoaDon()) &&
	            Objects.equals(getHangHoa(), that.getHangHoa());
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getHoaDon(), getHangHoa());
	}

	
}
