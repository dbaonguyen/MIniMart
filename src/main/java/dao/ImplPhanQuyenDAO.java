package dao;

import java.util.List;

import org.hibernate.Session;

import entity.NhanVien;
import entity.PhanQuyen;
import utils.HibernateHelper;

public class ImplPhanQuyenDAO implements IPhanQuyenDAO {

	private Session ss;

	public ImplPhanQuyenDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<PhanQuyen> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<PhanQuyen> lst = ss.createQuery("FROM PhanQuyen").list();
		ss.close();
		return lst;
	}
	
	@Override
	public PhanQuyen selectById(int idpq) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		PhanQuyen pq = (PhanQuyen) ss.createQuery("FROM PhanQuyen WHERE id = :idpq").setParameter("idpq", idpq)
				.getSingleResult();
		ss.close();
		return pq;
	}
}
