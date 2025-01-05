package com.poly.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.dto.DoanhThuTheoThang;
import com.poly.entity.Order;


public interface OrderDAO extends JpaRepository<Order, Long>{
	List<Order> findByAccount_Username(String username);

    @Query("SELECT NEW com.poly.dto.DoanhThuTheoThang(YEAR(o.createDate), MONTH(o.createDate), DAY(o.createDate), SUM(od.price * od.quantity)) " +
           "FROM Order o " +
           "JOIN o.orderDetails od " +
           "WHERE (:nam IS NULL OR YEAR(o.createDate) = :nam) " +
           "AND (:thang IS NULL OR MONTH(o.createDate) = :thang) " +
           "AND (:ngay IS NULL OR DAY(o.createDate) = :ngay) " +
           "GROUP BY YEAR(o.createDate), MONTH(o.createDate), DAY(o.createDate)")
    List<DoanhThuTheoThang> thongKeDoanhThuTheoNgay(@Param("nam") Integer nam, @Param("thang") Integer thang, @Param("ngay") Integer ngay);

    @Query("SELECT NEW com.poly.dto.DoanhThuTheoThang(YEAR(o.createDate), MONTH(o.createDate), 0, SUM(od.price * od.quantity)) " +
            "FROM Order o " +
            "JOIN o.orderDetails od " +
            "WHERE (:nam IS NULL OR YEAR(o.createDate) = :nam) " +
            "AND (:thang IS NULL OR MONTH(o.createDate) = :thang) " +
            "GROUP BY YEAR(o.createDate), MONTH(o.createDate)")
     List<DoanhThuTheoThang> thongKeDoanhThuTheoThang(@Param("nam") Integer nam, @Param("thang") Integer thang);

    @Query("SELECT NEW com.poly.dto.DoanhThuTheoThang(YEAR(o.createDate), 0, 0, SUM(od.price * od.quantity)) " +
           "FROM Order o " +
           "JOIN o.orderDetails od " +
           "WHERE (:nam IS NULL OR YEAR(o.createDate) = :nam) " +
           "GROUP BY YEAR(o.createDate)")
    List<DoanhThuTheoThang> thongKeDoanhThuTheoNam(@Param("nam") Integer nam);
    
    @Query("SELECT NEW com.poly.dto.DoanhThuTheoThang(YEAR(o.createDate), MONTH(o.createDate), DAY(o.createDate), SUM(od.price * od.quantity)) " +
	           "FROM Order o " +
	           "JOIN o.orderDetails od " +
	           "GROUP BY YEAR(o.createDate), MONTH(o.createDate), DAY(o.createDate)")
	List<DoanhThuTheoThang> thongKeDoanhThu();

    @Query("SELECT o FROM Order o WHERE MONTH(o.createDate) = :month")
    List<Order> findOrdersByMonth(@Param("month") int month);
	
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);

    
}
