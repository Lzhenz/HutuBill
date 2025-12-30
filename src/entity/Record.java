package entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    public int spend;
    public int id;
    public int cid;
    public String comment;
    public Date date;
}
