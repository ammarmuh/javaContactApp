/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactpack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class contactQuery {
    
    public void insertContact(contact cont){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `mycontact`(`name`, `email`, `phone`, `groupc`, `pic`, `address`, `userid`) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, cont.getName());
            ps.setString(2, cont.getEmail());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getGroupc());
            ps.setBytes(5, cont.getPic());
            ps.setString(6, cont.getAddress());
            ps.setInt(7, cont.getUid());
            
            if(ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "New Contact Added");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateContact(contact cont, boolean withImage){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        String updateQuery = "";
        
        // if the user want to update the contact profile too
        if(withImage == true){
            
            updateQuery = "UPDATE `mycontact` SET `name`= ?,`email`= ?,`phone`= ?,`groupc`= ?,`pic`= ?,`address`= ? WHERE `id`= ?";
            try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, cont.getName());
            ps.setString(2, cont.getEmail());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getGroupc());
            ps.setBytes(5, cont.getPic());
            ps.setString(6, cont.getAddress());
            ps.setInt(7, cont.getCid());
            
            if(ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Data Edited");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } else { //if user want to keep the same image [remove the image from the update]
            
            updateQuery = "UPDATE `mycontact` SET `name`= ?,`email`= ?,`phone`= ?,`groupc`= ?,`address`= ? WHERE `id`= ?";
            try {
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, cont.getName());
            ps.setString(2, cont.getEmail());
            ps.setString(3, cont.getPhone());
            ps.setString(4, cont.getGroupc());
            ps.setString(5, cont.getAddress());
            ps.setInt(6, cont.getCid());
            
            if(ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "New Contact Added");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }
            
            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
    
    
    public void deleteContact(int cid){
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM `mycontact` WHERE `id` = ?");
            ps.setInt(1, cid);
            
            if(ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Deleted");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Id do not exist");

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // create a list of contact
    public ArrayList<contact> contactList( int userId ){
        
        ArrayList<contact> clist = new ArrayList<contact>();
        
        Connection con = MyConnection.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `name`, `email`, `phone`, `groupc`, `pic`, `address` FROM `mycontact` WHERE userId = " + userId);
            
            contact ct;
            
            while(rs.next()){
                ct = new contact(rs.getInt("id"), 
                                 rs.getString("name"),
                                 rs.getString("email"),
                                 rs.getString("phone"),
                                 rs.getString("groupc"),
                                 rs.getString("address"),
                                 rs.getBytes("pic"),
                                 userId);
                
                clist.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clist;
    }
    
}
