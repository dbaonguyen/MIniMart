package dao;

import java.util.List;

import org.hibernate.Session;

import entity.VanChuyen;
import utils.HibernateHelper;

public class ImplVanChuyenDAO implements IVanChuyenDAO {
	
	private Session ss;
	
	public ImplVanChuyenDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<VanChuyen> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<VanChuyen> lst = ss.createQuery("FROM VanChuyen").list();
		ss.close();
		return lst;
	}

}
