package dao;

import java.util.List;

import entity.HoaDon;

public interface IHoaDonDAO {
	public List<HoaDon> selectAll();
	public HoaDon selectById(int idhd);
	public boolean update(HoaDon hd);
	public List<HoaDon> search(String title);
	
}
