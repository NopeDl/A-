package dao.impl;
import dao.MoneyDealDao;
import pojo.userMoneyPojo;
import unit.daoFather;
import unit.wzxSQL;
public class MoneyDealDaoImple extends daoFather implements MoneyDealDao {
    private String sql;
    @Override
    public void addUser(String name, Integer money) {
        sql="insert into user_money(user_name,user_money) values(?,?)";
        wzxSQL.useWzxSQL(sql,Integer.class,name,money);
    }

    @Override
    public void updateBalance(String name, Integer money) {
        sql="update user_money set user_money=? where user_name=?";
        wzxSQL.useWzxSQL(sql,Integer.class,money,name);
    }
    @Override
    public userMoneyPojo checkMoneyDao(String name) {
       sql="select * from user_money where user_name=?";
        Object result = wzxSQL.useWzxSQL(sql, userMoneyPojo.class, name);
        return (userMoneyPojo)result;
    }
}
