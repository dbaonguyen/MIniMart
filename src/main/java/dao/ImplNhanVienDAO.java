package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.KhachHang;
import entity.NhanVien;
import utils.HibernateHelper;

public class ImplNhanVienDAO implements INhanVienDAO {

	public Session ss;

	public ImplNhanVienDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<NhanVien> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<NhanVien> lst = ss.createQuery("FROM NhanVien ORDER BY id").list();
		ss.close();

		return lst;
	}

	@Override
	public NhanVien selectById(int idnv) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		NhanVien nv = (NhanVien) ss.createQuery("FROM NhanVien WHERE id = :idnv").setParameter("idnv", idnv)
				.getSingleResult();
		ss.close();
		return nv;
	}

	@Override
	public boolean insert(NhanVien nv) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		ss.save(nv);
		boolean isOk = false;
		if (nv.getId() > 0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();

		return isOk;
	}

	@Override
	public boolean update(NhanVien nv) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			ss.update(nv);
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
	public boolean delete(int idnv) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			NhanVien nv = ss.get(NhanVien.class, idnv);
			ss.delete(nv);
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
	public List<NhanVien> search(String title) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<NhanVien> lst = ss.createQuery("FROM NhanVien WHERE hovaten LIKE :search")
				.setParameter("search", "%" + title + "%").list();
		ss.close();
		return lst;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		long count = (long) ss.createQuery("SELECT COUNT(*) FROM NhanVien").uniqueResult();
		ss.getTransaction().commit();
		ss.close();
		return count;
	}

	@Override
	public String nhanVienTichCuc() {
	    String result = "";
	    Session session = HibernateHelper.getSessionFactory().openSession();
	    try {
	        String hql = "SELECT nv.hovaten FROM NhanVien nv INNER JOIN HoaDon hd ON nv.id = hd.nhanVien.id	 GROUP BY nv.id, nv.hovaten ORDER BY COUNT(hd.id) DESC";
	        session.beginTransaction();
	        result = (String) session.createQuery(hql).setMaxResults(1).uniqueResult();
	        session.getTransaction().commit();
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return result;
	}
	


	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (ss != null) {
	        ss.close();
	    }
	}
	
	@Override
    public NhanVien getEmployeeByUsername(String username, String password) {
		ss.beginTransaction();
		NhanVien nv = (NhanVien) ss.createQuery("FROM NhanVien WHERE username = :username AND password = :password")
				.setParameter("username", username).setParameter("password", password).uniqueResult();
		ss.getTransaction().commit();
		return nv;

       
    }

	@Override
	public NhanVien accDetail(int idnv) {
		ss.beginTransaction();
		NhanVien nv = (NhanVien) ss.createQuery("FROM NhanVien WHERE id = :idnv").setParameter("idnv", idnv)
				.getSingleResult();
		ss.close();
		return nv;
	}
	
	
	



	

	
	


}
