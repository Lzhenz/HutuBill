package dao;


import entity.Category;
import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 总件数查询，CRUD，分页查询
 */
public class CategoryDAO {

    public int getTotal(){
        int total = 0 ;
        try(Connection c = DBUtil.getConnection(); Statement st = c.createStatement()){
            String sql = "select count(*) from category";
            ResultSet rs = st.executeQuery(sql);
            // 这里 while 和 if都可以，if更好
            while (rs.next()) {
                total = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    // add
    public void add(Category category){
        String sql = "insert into category values(null , ?)";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            String name = category.name;
            ps.setString(1 , name);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                category.id = id;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // delete
    public void delete(int id){
        String sql = "delete from category where id = " + id;
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update
    public void update(Category category){
        String sql = "update category set name = ? where id = ?";
        try (Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            int id = category.id;
            String name = category.name;
            ps.setString(1, name);
            ps.setInt(2 , id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Category get(int id){
        Category category = null;
        String sql = "select * from category where id = " + id;
        try (Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                category = new Category();
                String name = rs.getString("name");
                category.id = id;
                category.name = name;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    // 分页查询
    public List<Category> list(){
        return list(0 , Short.MAX_VALUE);
    }

    public List<Category> list(int start , int count){
        String sql = "select * from category limit ?, ?";
        List<Category> categories = new ArrayList<>();
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                int id = rs.getInt("id");
                String name = rs.getString("name");

                category.id = id;
                category.name = name;
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }
}



















