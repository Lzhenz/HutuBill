package dao;

import entity.Config;
import util.DBUtil;

import java.sql.*;

public class ConfigDAO {

    public int getTotal(){
        int total = 0;

        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()){
            String sql = "select count(*) from config";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                total = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    // add
    public void add(Config config){
        String sql = "insert into config values(null , ? , ?)";
        try(Connection c =  DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            // 把从外部传递进来的参数放置到sql的参数中
            ps.setString(1, config.key);
            ps.setString(2, config.value);
            ps.execute();
            // 如果是使用execute，则会返回ResultSet
            // 这一步的意思是获取数据库生成的自增key的数值,用于插入子表或者返回给前段进行刷新显示
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                config.id = id;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //



























}






