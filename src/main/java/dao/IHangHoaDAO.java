package dao;

import java.util.List;

import entity.HangHoa;

public interface IHangHoaDAO {
	public List<HangHoa> selectAll();
	public HangHoa selectById(int idhh);
	public boolean insert(HangHoa hh);
	public boolean update(HangHoa hh);
	public boolean delete(int idhh);
	public List<HangHoa> search(String title);
	long count();
	public String sanPhamBanChay();
	public List<HangHoa> sanPhamCanNhap();

}
