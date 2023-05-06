package dao;

import java.util.List;

import entity.NhanVien;

public interface INhanVienDAO {
	public List<NhanVien> selectAll();
	public NhanVien selectById(int idnv);
	public boolean insert(NhanVien nv);
	public boolean update(NhanVien nv);
	public boolean delete(int idnv);
	public List<NhanVien> search(String title);
	long count();
	public String nhanVienTichCuc();
	public void close();
	public NhanVien getEmployeeByUsername(String username, String password);
	public NhanVien accDetail(int idnv);


	
}
