package dao;

import java.util.List;

import org.hibernate.Session;

import entity.DonViTinh;
import utils.HibernateHelper;

public class ImplDonViTinhDAO implements IDonViTinhDAO {

	private Session ss;

	public ImplDonViTinhDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<DonViTinh> selectAll() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<DonViTinh> lst = ss.createQuery("FROM DonViTinh").list();
		ss.close();

		return lst;
	}

}
