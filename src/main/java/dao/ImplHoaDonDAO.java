package dao;

import java.util.List;

import org.hibernate.Session;

import entity.HangHoa;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.ThanhToan;
import entity.VanChuyen;
import utils.HibernateHelper;

public class ImplHoaDonDAO implements IHoaDonDAO{
	
	public Session ss;
	
	public ImplHoaDonDAO() {
		// TODO Auto-generated constructor stub
		ss = HibernateHelper.getSessionFactory().openSession();
	}
	
	@Override
	public List<HoaDon> selectAll() {
		ss.beginTransaction();
		List<HoaDon> lst = ss.createQuery("FROM HoaDon ORDER BY id").list();
		ss.close();
		return lst;
	}
	
	

	@Override
	public boolean update(HoaDon hd) {
	    ss.beginTransaction();
	    try {
	        // Retrieve the existing HoaDon from the database
	        HoaDon existingHd = ss.get(HoaDon.class, hd.getId());

	        // Update the not null attributes from the foreign key tables
	        if (hd.getKhachHang() != null) {
	            KhachHang kh = ss.get(KhachHang.class, hd.getKhachHang().getId());
	            existingHd.setKhachHang(kh);
	        }


	        if (hd.getNhanVien() != null) {
	            NhanVien nv = ss.get(NhanVien.class, hd.getNhanVien().getId());
	            existingHd.setNhanVien(nv);
	        }

	        if (hd.getVanChuyen() != null) {
	            VanChuyen vc = ss.get(VanChuyen.class, hd.getVanChuyen().getId());
	            existingHd.setVanChuyen(vc);
	        }

	        if (hd.getThanhToan() != null) {
	            ThanhToan tt = ss.get(ThanhToan.class, hd.getThanhToan().getId());
	            existingHd.setThanhToan(tt);
	        }

	        // Update the remaining attributes of the HoaDon entity
	        existingHd.setNgaytao(hd.getNgaytao());
	        existingHd.setTrangthai(hd.getTrangthai());

	        // Save the updated HoaDon to the database
	        ss.update(existingHd);
	        ss.getTransaction().commit();


	    } catch (Exception e) {
	        System.out.println("Lỗi: " + e.getMessage());
	        ss.getTransaction().rollback();
	    } finally {
	        ss.close();
	    }
        return false;
	}





	@Override
	public List<HoaDon> search(String title) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		List<HoaDon> lst = ss.createQuery("FROM HoaDon hd WHERE hd.sdtnhan LIKE :search").setParameter("search", "%" + title + "%").list();
		ss.getTransaction().commit();
        ss.close();
		return lst;
	}

	@Override
	public HoaDon selectById(int idhd) {
		// TODO Auto-generated method stub
		ss.beginTransaction();
		HoaDon hd = (HoaDon) ss.createQuery("FROM HoaDon WHERE id = :idhd").setParameter("idhd", idhd).getSingleResult();
		ss.close();
		
		return hd;
	}

}
