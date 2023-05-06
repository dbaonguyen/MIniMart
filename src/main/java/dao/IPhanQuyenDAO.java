package dao;

import java.util.List;

import entity.PhanQuyen;

public interface IPhanQuyenDAO {
	public List<PhanQuyen> selectAll();

	public PhanQuyen selectById(int idpq);

}
