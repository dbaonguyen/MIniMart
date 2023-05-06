package dao;

import java.util.List;

import entity.ChungLoai;

public interface IChungLoaiDAO {
	public List<ChungLoai> selectAll();
	public boolean insert(ChungLoai cl);
	long count();
}
