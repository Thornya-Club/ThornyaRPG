package club.thornya.thornyarpg.users.models;

import club.thornya.thornyarpg.users.enums.AccountType;
import club.thornya.thornyarpg.users.enums.Gender;
import club.thornya.thornyarpg.users.enums.Rank;

import java.util.Date;

public class User {
    private int index;
    private String nickName;
    private Date firstLogin;
    private int level;
    private Gender gender;
    private double moneyBalance;
    private double moneyInBank;
    private double cashBalance;
    private int golds;
    private int warns;
    private AccountType accountType;
    private long vipTime;
    private int exp;
    private int expMax;
    private int mana;
    private int manaMax;
    private int lifeMax;
    private int attribute;
    private int killedTimes;
    private int diedTimes;
    //private Clan clan;
    //private Job job;
    private Rank rank;
    private String inventory;
    private Date lastLogin;

    public User(int index, String nickName, Gender gender, Rank rank, String inventory){
        this.index = index;
        this.nickName = nickName;
        this.firstLogin = new Date();
        this.gender = gender; //
        this.level = 0;
        this.moneyBalance = 300;
        this.moneyInBank = 0;
        this.cashBalance = 0;
        this.golds = 0;
        this.accountType = AccountType.FREE;
        this.vipTime = -1;
        this.exp = 0;
        this.expMax = 1000;
        this.mana = 20;
        this.manaMax = 20;
        this.lifeMax = 20;
        this.attribute = 0;
        //this.clan = null;
        //this.job = null;
        this.rank = rank;
        this.inventory = inventory;
        this.lastLogin = new Date();

    }

}
