package dao;

import java.util.List;

import org.hibernate.Session;

import entity.HangHoa;
import entity.NhanVien;
import utils.HibernateHelper;

public class ImplHangHoaDAO implements IHangHoaDAO {

	public Session ss;

	public ImplHangHoaDAO() {
		ss = HibernateHelper.getSessionFactory().openSession();
	}

	@Override
	public List<HangHoa> selectAll() {
		ss.beginTransaction();
		List<HangHoa> lst = ss.createQuery("FROM HangHoa ORDER BY id").list();
		ss.close();
		return lst;
	}

	@Override
	public HangHoa selectById(int idhh) {
		ss.beginTransaction();
		HangHoa hh = (HangHoa) ss.createQuery("FROM HangHoa WHERE id = :idhh").setParameter("idhh", idhh)
				.getSingleResult();
		ss.close();
		return hh;
	}

	@Override
	public boolean insert(HangHoa hh) {
		ss.beginTransaction();
		ss.save(hh);
		boolean isOk = false;
		if (hh.getId() > 0) {
			isOk = true;
		}
		ss.getTransaction().commit();
		ss.close();

		return isOk;
	}

	@Override
	public boolean update(HangHoa hh) {
		ss.beginTransaction();
		try {
			ss.update(hh);
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
	public boolean delete(int idhh) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		try {
			HangHoa hh = ss.get(HangHoa.class, idhh);
			ss.delete(hh);
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
	public List<HangHoa> search(String title) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<HangHoa> lst = ss.createQuery("FROM HangHoa WHERE tenhanghoa LIKE :search")
				.setParameter("search", "%" + title + "%").list();
		ss.close();
		return lst;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		long count = (long) ss.createQuery("SELECT COUNT(*) FROM HangHoa").uniqueResult();
		ss.getTransaction().commit();
		return count;
	}

	@Override
	public String sanPhamBanChay() {
		String hql = "SELECT hdct.hangHoa.tenhanghoa FROM HoaDonChiTiet hdct "
				+ "GROUP BY hdct.hangHoa.id, hdct.hangHoa.tenhanghoa " + "ORDER BY SUM(hdct.soluong*hdct.gia) DESC";
		ss.beginTransaction();
		String result = (String) ss.createQuery(hql).setMaxResults(1).uniqueResult();
		ss.getTransaction().commit();
		return result;
	}

	@Override
	public List<HangHoa> sanPhamCanNhap() {
		ss.beginTransaction();
		List<HangHoa> lst = ss.createQuery("SELECT hh.tenhanghoa FROM HangHoa hh where hh.soluong < 100").list();
		ss.close();
		return lst;
	}

}
