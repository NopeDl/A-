public class customer {  
     private static boolean isVip=false;  
    private static int nowMoney = 0;  
## 获取客户当前余额
    public int getNowMoney() {  
        return nowMoney;  
    }  
  
    public void setNowMoney(int nowMoney) {  
        this.nowMoney = nowMoney;  
    }  
  
    Scanner sc = new Scanner(System.in);  
## 进行货币充值操作
    public void exchangeMoney() {//充值货币  
        System.out.println("请输入你想充值的钱币");  
        int money = sc.nextInt();  
        this.nowMoney += money;  
        System.out.println("成功充值" + money + "元," + "当前余额为:" + this.nowMoney);  
    }  
## 付款操作
    public void pay() {  
        System.out.println("请输入你需支付的钱币");  
        int money = sc.nextInt();  
        this.nowMoney -= money;  
        System.out.println("成功付款" + money + "元," + "当前余额为:" + this.nowMoney);  
    }  
## 成为VIP会员,
    public boolean vip() { 
        System.out.println("购买VIP会员需支付30元,请问您确定想要购买吗？输入y则购买，输入n则拒绝购买。");  
        String choose = sc.next();  
        while (true) {  
                if (choose.equals("y")) {  
                    if (isVip) {  
                        System.out.println("你已经购买过会员了，不能再次购买");  
                        return true;}  
                    else if (this.getNowMoney() >= 30) {  
                        this.nowMoney -= 30;  
                        System.out.println("您已成为尊贵的VIP会员，享受订房八折优惠。您的当前余额为：" + this.nowMoney);  
                        isVip=true;  
                        return true;  
                    } else {  
                        System.out.println("对不起，你的余额不足，请充值后再购买VIP,当前余额为：" + this.getNowMoney());  
                        isVip=false;  
                        return false;  
                    }  
                } else if (choose.equals("n")) {  
                    System.out.println("你已拒绝购买VIP会员,你的当前余额为：" + this.nowMoney);  
                    isVip=false;  
                    return false;  
                } else if (!choose.equals("y") || !choose.equals("n")) {  
                    System.out.println("你输入的信息有误,请重新输入！");  
                }  
            }  
        }  
    }