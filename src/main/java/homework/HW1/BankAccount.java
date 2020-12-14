package homework.HW1;

public class BankAccount {
    int accountNumber;
    int balance;


    /*Создать класс BankAccount который будет иметь два поля 	accountNumber и balance.
    Реализовать в классе методы setBalance() который будет задавать баланс ,
     credit() метод должен начислять средства на счет, debit() - снимать средтва со  счета.
      Реализовать условие что если сумма снятия меньше чем остаток
       на счету - вывести сообщение : “Сумма снятия больше чем остаток на счету!” .
       Создать обьект класса и проверить работу программы.
     */

    public int setBalance(int balance) { //задаем баланс
        this.balance = balance;
        return balance;
    }

    public int getBalance() { //получаем остаток на счету
        return balance;
            }

    public int credit(int sum) {       //зачисление
        int dig = setBalance(getBalance()+sum);
        System.out.println("+" + sum );
        System.out.println("После зачисления " + getBalance());
        return dig;

    }

    public int  debit(int debitSum) {

        int result;
        if(debitSum>getBalance()){
            System.out.println("Сумма снятия больше чем остаток на счету!");
            result = -1;
        }
        else {
            result = setBalance(getBalance() - debitSum);
            System.out.println("-" + debitSum);
            System.out.println("После снятия " + getBalance());

        }
        return result;
    }

    public void print(String forprint){
        System.out.println(forprint);
    }

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount();
        acc1.setBalance(500);
        acc1.print("Баланс: " + acc1.getBalance());
        acc1.credit(400);
        acc1.debit(800);
        acc1.debit(400);
    }
}


