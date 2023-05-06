package dao;

import java.util.List;

import entity.DiemThuong;

public interface IDiemThuongDAO {
	public List<Object[]> selectAll();

	List<Object[]> searchByTen(String ten);
}
