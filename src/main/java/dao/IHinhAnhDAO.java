package dao;

import java.util.List;

import entity.HinhAnh;

public interface IHinhAnhDAO {
	public List<HinhAnh> selectAll();
	public boolean insert(HinhAnh ha);
}
