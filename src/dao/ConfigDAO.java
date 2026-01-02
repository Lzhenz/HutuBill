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

    // update
    public void update(Config config){
        String sql = "update config set key_ = ? , value = ? where id = ?";

        /**
         * 开始连接数据库并且尝试更新数据库，先通过PreparedStatement进行预编译
         * 如果预编译没有问题，则进入
         */
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            // 这里的parameterIndex是对于方法内定义的sql语句的位置而言的，而不是在数据库中的位置
            ps.setString(1, config.key);
            ps.setString(2, config.value);
            ps.setInt(3, config.id);
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 这里使用id 而不是一整个Config的原因是，可以避免脏数据
     * 并且这里也不再需要进行预编译了
     * @param id
     */
    public void delete(int id){
        try(Connection c = DBUtil.getConnection() ; Statement s = c.createStatement()){
            String sql = "delete from config where id = "  + id;
            s.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Config get(int id){
        Config config = null;
        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()){
            String sql = "select * from config where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()){
                config = new Config();
                String key = rs.getString("key_");
                String value = rs.getString("value");
                config.key = key;
                config.value = value;
                // 这里的id要注意
                config.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }
























}






