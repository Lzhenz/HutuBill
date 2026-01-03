package dao;

import entity.Config;
import entity.Record;
import util.DBUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDAO {
    /**
     * 字段：id spend cid comment date
     */

    // 查询个数
    public int getTotal(){
        int total = 0;
        String sql = "select count(*) from record";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e){
        }
        return total;
    }

    // add
    public void add(Record record){
        // 字段：id spend cid comment date
        String sql = "insert into record values(null, ?, ? ,?, ?)";
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            int spend = record.spend;
            int cid = record.cid;
            String comment = record.comment;
            Date date = DateUtil.util2sql(record.date);

            ps.setInt(1, spend);
            ps.setInt(2, cid);
            ps.setString(3, comment);
            ps.setDate(4, date);

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                int id = rs.getInt(1);
                record.id = id;
            }
        } catch (SQLException e){

        }
    }

    // update
    public void update(Record record) {
        // id spend cid comment date
        String sql = "update record set spend = ? , cid = ? , comment = ? , date = ? where id = ?";
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            int spend = record.spend;
            int cid = record.cid;
            String comment = record.comment;
            Date date = DateUtil.util2sql(record.date);
            int id = record.id;

            ps.setInt(1, spend);
            ps.setInt(2, cid);
            ps.setString(3, comment);
            ps.setDate(4, date);
            ps.setInt(5, id);

            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // delete
    public void delete(int id){
        String sql = "delete from record where id = " + id;
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // getById
    public Record get(int id){
        Record record = null;
        String sql = "select * from record where id = " + id;
        try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                record = new Record();
                record.id = id;
                record.spend = rs.getInt("spend");
                record.cid = rs.getInt("cid");
                record.comment = rs.getString("comment");
                record.date = rs.getDate("date");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return record;
    }

    // 进行分页查询
    public List<Record> list(){
        return list(0, Short.MAX_VALUE);
    }

    public List<Record> list(int start , int count){
        List<Record> records = new ArrayList<>();
        String sql = "select * from record limit ?,?";
        try (Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Record record = new Record();

                int spend = record.spend;
                int cid = record.cid;
                String comment = record.comment;
                Date date = DateUtil.util2sql(record.date);
                int id = record.id;

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;

                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }
}




















