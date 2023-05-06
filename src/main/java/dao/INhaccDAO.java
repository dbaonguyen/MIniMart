package dao;

import java.util.List;

import entity.NhaCungCap;


public interface INhaccDAO {
	public List<NhaCungCap> selectAll();
	public NhaCungCap selectById(int idncc);
	public boolean insert(NhaCungCap ncc);
	public boolean update(NhaCungCap ncc);
	public boolean delete(int idncc);
	public List<NhaCungCap> search(String title);
	long count();
	public String nhaCungCapBanChayNhat();
}
