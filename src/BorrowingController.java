
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kali
 */
public class BorrowingController {
Connection conn;
ResultSet rs;
PreparedStatement pst;
    public BorrowingController() {
    }
    
    public void sendRequest(String sid, String studentName,int bid, String bookTitle, Date due, int borrowingNumber){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                String sql = "INSERT INTO borrowing VALUES (null,?,?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, sid);
                pst.setString(2, studentName);
                pst.setInt(3, bid);
                pst.setString(4, bookTitle);
                pst.setInt(5, borrowingNumber);
                pst.setObject(6, due);
                pst.setString(7, "Processing");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Request sent!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateBorrowing(int id,int bookid, String title,int number,Date due){
        try{
            String query = "SELECT number, title FROM book WHERE bookid="+bookid;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            int stock=0;
            String bookTitle="";
            while (rs.next()){
                stock = rs.getInt("number");
                bookTitle = rs.getString("title");
            }
            if (number>stock || !bookTitle.equals(title)){
                JOptionPane.showMessageDialog(null, "Vui lòng điền lại thông tin");
            }else{
                String sql = "UPDATE borrowing SET bookid=?, title=?, number=?, due=? WHERE id="+id;
                pst = conn.prepareStatement(sql);
                pst.setInt(1, bookid);
                pst.setString(2, title);
                pst.setInt(3, number);
                pst.setObject(4, due);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update successful!");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deleteBorrowing(int id){
        try{
            String query = "DELETE FROM borrowing WHERE id="+id;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            pst=conn.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xóa phiếu mượn");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
