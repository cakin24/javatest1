package com.itheima.pattern.memento.white_box;

/**
 * @version v1.0
 * @ClassName: RoleStateMemento
 * @Description: 备忘录角色类
 * 负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人
 * @Author: cakin
 */
public class RoleStateMemento {

    private int vit; // 生命力
    private int atk; // 攻击力
    private int def; // 防御力

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public RoleStateMemento() {
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
