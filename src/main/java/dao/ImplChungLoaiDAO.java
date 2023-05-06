package dao;

import java.util.List;

import org.hibernate.Session;


import entity.ChungLoai;
import utils.HibernateHelper;

public class ImplChungLoaiDAO implements IChungLoaiDAO {
	
	public Session ss;
	
	
	
	
	public ImplChungLoaiDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<ChungLoai> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<ChungLoai> lst = ss.createQuery("FROM ChungLoai").list();
		ss.close();
		return lst;
	}

	@Override
	public boolean insert(ChungLoai cl) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		ss.save(cl);
		boolean isOk = false;
		if(cl.getId() > 0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();
		
		return isOk;
	}

	@Override
	public long count() {
		ss.beginTransaction();
        long count = (long) ss.createQuery("SELECT COUNT(*) FROM ChungLoai").uniqueResult();
        ss.getTransaction().commit();
        return count;
	}

	

}
