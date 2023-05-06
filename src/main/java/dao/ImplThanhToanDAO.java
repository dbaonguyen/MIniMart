package dao;

import java.util.List;

import org.hibernate.Session;

import entity.ThanhToan;
import utils.HibernateHelper;

public class ImplThanhToanDAO implements IThanhToanDAO {
	
	private Session ss;
	
	public ImplThanhToanDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<ThanhToan> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<ThanhToan> lst = ss.createQuery("FROM ThanhToan").list();
		ss.close();
		return lst;
	}

}
