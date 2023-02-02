package dao.impl;
import dao.VipDao;
import pojo.vipPojo;
import unit.daoFather;
import unit.wzxSQL;

public class VipDaoImpl extends daoFather implements VipDao {
    private String sql;
    @Override
    public vipPojo isVipDao(String name) {
        sql = "select * from vip_user where name=?";
        Object result = wzxSQL.useWzxSQL(sql, vipPojo.class, name);
        return (vipPojo) result;
    }
    @Override
    public void beVip(String name) {
         sql="insert into vip_user(name) values(?)";
         wzxSQL.useWzxSQL(sql,Integer.class,name);
    }
}
