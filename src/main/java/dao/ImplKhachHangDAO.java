package dao;

import java.util.List;

import org.hibernate.Session;
  
import entity.KhachHang;
import utils.HibernateHelper;

public class ImplKhachHangDAO implements IKhachHangDAO {
	
	public Session ss;
	
	public ImplKhachHangDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<KhachHang> selectAll() {
		ss.beginTransaction(); // Mở giao dịch
		List<KhachHang> lst = ss.createQuery("FROM KhachHang ORDER BY id").list();
		ss.close();

		return lst;
	}

	@Override
	public KhachHang selectById(int idkh) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		KhachHang kh  = (KhachHang) ss.createQuery("FROM KhachHang WHERE id = :idkh").setParameter("idkh", idkh).getSingleResult();
		ss.close();
		return kh;
	}

	@Override
	public boolean insert(KhachHang kh) {
		ss.beginTransaction();
		ss.save(kh);
		boolean isOk = false;
		if (kh.getId()>0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();
		
		return isOk;
	}

	@Override
	public boolean update(KhachHang kh) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			ss.update(kh);
			ss.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			ss.close();
		}
		
		
		return false;
	}

	@Override
	public boolean delete(int idkh) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			KhachHang kh = ss.get(KhachHang.class, idkh);
			ss.delete(kh);
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		} finally {
			ss.close();
		}
		return false;
	}

	@Override
	public List<KhachHang> search(String title) {
		ss.beginTransaction();
		List<KhachHang> lst = ss.createQuery("FROM KhachHang WHERE dien_thoai LIKE :search").setParameter("search","%" + title + "%").list();
		ss.close();
		return lst;
	}

}
