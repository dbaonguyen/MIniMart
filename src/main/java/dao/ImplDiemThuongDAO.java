package dao;

import java.util.List;

import org.hibernate.Session;

import entity.DiemThuong;
import utils.HibernateHelper;

public class ImplDiemThuongDAO implements IDiemThuongDAO {
	
	
	public Session ss;
	
	public ImplDiemThuongDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<Object[]> selectAll() {
	    ss.beginTransaction();
	    String hql = "SELECT dt.khachHang.ho AS ho, dt.khachHang.ten AS ten, SUM(dt.diem) AS tongDiemThuong FROM DiemThuong dt GROUP BY dt.khachHang.ho, dt.khachHang.ten";
	    List<Object[]> results = ss.createQuery(hql).list();
	    ss.close();
	    return results;
	}
	
	@Override
    public List<Object[]> searchByTen(String ten) {
        ss.beginTransaction();
        String hql = "SELECT dt.khachHang.ho AS ho, dt.khachHang.ten AS ten, SUM(dt.diem) AS tongDiemThuong FROM DiemThuong dt WHERE dt.khachHang.ten LIKE :ten GROUP BY dt.khachHang.ho, dt.khachHang.ten";
        List<Object[]> results = ss.createQuery(hql)
                                    .setParameter("ten", "%" + ten + "%")
                                    .list();
        ss.getTransaction().commit();
        ss.close();
        return results;
    }
}
