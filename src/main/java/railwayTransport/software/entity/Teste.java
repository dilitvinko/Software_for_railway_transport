package railwayTransport.software.entity;

import javax.persistence.Entity;

@Entity
public class Teste extends BaseEntity{
  private int age;
  private int heal;

  public Teste() {
  }

  public Teste(int age, int heal) {
    this.age = age;
    this.heal = heal;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeal() {
    return heal;
  }

  public void setHeal(int heal) {
    this.heal = heal;
  }
}
