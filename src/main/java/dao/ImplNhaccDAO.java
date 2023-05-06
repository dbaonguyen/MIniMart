package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import entity.NhaCungCap;
import utils.HibernateHelper;

public class ImplNhaccDAO implements INhaccDAO {
	
	public Session ss;
	
	public ImplNhaccDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
		
	}
	
	@Override
	public List<NhaCungCap> selectAll() {
		ss.beginTransaction(); // Mở giao dịch
		List<NhaCungCap> lst = ss.createQuery("FROM NhaCungCap ORDER BY id").list();
		ss.close();

		return lst;
	}

	@Override
	public NhaCungCap selectById(int idncc) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		NhaCungCap ncc  = (NhaCungCap) ss.createQuery("FROM NhaCungCap WHERE id = :idncc").setParameter("idncc", idncc).getSingleResult();
		ss.close();
		return ncc;
	}

	@Override
	public boolean insert(NhaCungCap ncc) {
		ss.beginTransaction();
		ss.save(ncc);
		boolean isOk = false;
		if (ncc.getId()>0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();
		
		return isOk;
	}

	@Override
	public boolean update(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			ss.update(ncc);
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
	public boolean delete(int idncc) {
		ss.beginTransaction();
		try {
			NhaCungCap ncc = ss.get(NhaCungCap.class, idncc);
			ss.delete(ncc);
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
	public List<NhaCungCap> search(String title) {
		ss.beginTransaction();
		List<NhaCungCap> lst = ss.createQuery("FROM NhaCungCap WHERE tennhacc LIKE :search").setParameter("search","%" + title + "%").list();
		ss.close();
		return lst;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		long count = (long) ss.createQuery("SELECT COUNT(*) FROM NhaCungCap").uniqueResult();
		ss.getTransaction().commit();
		return count;
	}

	@Override
	public String nhaCungCapBanChayNhat() {
	    String result = "";
	    Session session = HibernateHelper.getSessionFactory().openSession();
	    try {
	        String hql = "SELECT ncc.tennhacc AS tenNCC " +
	                     "FROM NhaCungCap ncc " +
	                     "INNER JOIN HangHoa hh ON ncc.id = hh.nhaCungCap.id " +
	                     "INNER JOIN HoaDonChiTiet hdct ON hh.id = hdct.hangHoa.id " +
	                     "GROUP BY ncc.id, ncc.tennhacc " +
	                     "ORDER BY SUM(hdct.soluong) DESC";
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


}
