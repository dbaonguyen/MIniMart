package dao;

import java.util.List;

import entity.KhachHang;

public interface IKhachHangDAO {
	public List<KhachHang> selectAll();
	public KhachHang selectById(int idkh);
	public boolean insert(KhachHang kh);
	public boolean update(KhachHang kh);
	public boolean delete(int idkh);
	public List<KhachHang> search(String title);
}
