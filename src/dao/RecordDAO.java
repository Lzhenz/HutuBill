package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecordDAO {
    /**
     * 字段：id spend cid comment date
     */

    public int getTotal(){
        int total = 0;
        String sql = "select count(*) from record";

        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

        } catch (SQLException e){

        }
        return total;
    }
}




















