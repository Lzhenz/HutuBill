package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
    public final static String budget = "budget";
    public final static String mysqlPath = "mysqlPath";
    public final static String default_budget = "500";

    static ConfigDAO dao = new ConfigDAO();
    // 初始化的时候如果数据库里面没有数据，则调用init将数据写入，避免出错
    static {
        init();
    }

    public static void init(){
        init(budget , default_budget);
        init(mysqlPath, "");
    }

    private static void init(String key, String value){
        Config config = ConfigService.dao.getByKey(key);
        if (config.key == null) {
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }

    // 通过调用service来调用D层进行数据库操作
    public String get(String key){
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    // update
    public void update(String key , String value){
        // 更新之前先判断是否有数据
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    // 这一步应该是给其他的地方进行调用数据使用的。
    public int getIntBudget(){
        return Integer.parseInt(get(budget));
    }
}
