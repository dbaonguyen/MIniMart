package dao;

import java.util.List;

import entity.HoaDonChiTiet;

public interface IHoaDonChiTietDAO {
	
	public List<Object[]> selectById(int idhd);
	
}
