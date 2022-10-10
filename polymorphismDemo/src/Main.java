public class Main {
    public static void main(String[] args) {
        // polymorphism -> Çok biçimlilik
        //loglama yöntemi
//        BaseLogger[] loggers = new BaseLogger[]{new FileLogger(), new EmailLogger(), new EmailLogger(), new ConsoleLogger()};
//        for (BaseLogger logger:loggers) {
//            logger.Log("Log mesajı");
//        }
        CustomerManager customerManager = new CustomerManager(new FileLogger());
        customerManager.add();
    }
}