package dao;

import java.util.List;

import org.hibernate.Session;


import entity.HinhAnh;
import utils.HibernateHelper;

public class ImplHinhAnhDAO implements IHinhAnhDAO {
	
	public Session ss;
	
	public ImplHinhAnhDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	
	@Override
	public List<HinhAnh> selectAll() {
		ss.beginTransaction();
		List<HinhAnh> lst = ss.createQuery("FROM HinhAnh").list();
		ss.close();
		return lst;
	}

	@Override
	public boolean insert(HinhAnh ha) {
		ss.beginTransaction();
		ss.save(ha);
		boolean isOk = false;
		if(ha.getId() > 0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();
		return isOk;
	}

}
