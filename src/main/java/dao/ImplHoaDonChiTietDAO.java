package dao;

import java.util.List;

import org.hibernate.Session;

import entity.HoaDonChiTiet;
import utils.HibernateHelper;

public class ImplHoaDonChiTietDAO implements IHoaDonChiTietDAO {

    public Session ss;

    public ImplHoaDonChiTietDAO() {
        ss = HibernateHelper.getSessionFactory().openSession();
    }

   

    @Override
    public List<Object[]> selectById(int idhd) {
        ss.beginTransaction();
        String hql = "SELECT hdct.hangHoa.tenhanghoa, hdct.soluong, hdct.gia, hdct.soluong * hdct.gia "
                + "FROM HoaDonChiTiet hdct INNER JOIN hdct.hoaDon h INNER JOIN hdct.hangHoa hh WHERE h.id = :idhd";
        List<Object[]> results = ss.createQuery(hql).setParameter("idhd", idhd).getResultList();
        ss.getTransaction().commit();
        ss.close();
        return results;
    }



   
}
