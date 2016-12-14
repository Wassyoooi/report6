package jp.ac.uryukyu.ie.e165719;

public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    public  void attack (LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        int weakPoint = (int) (Math.random() * 100 + 1);
        if (isDead() == false) {
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }else if(1 <= weakPoint && weakPoint <= 20){
                damage = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }

    @Override
    public void wounded(int damage) {
        setHitPoint(getHitPoint()-damage);
        if (getHitPoint() < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}