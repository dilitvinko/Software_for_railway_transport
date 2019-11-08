package entity.train;


import entity.BaseEntity;

public class Carriage extends BaseEntity {

  private int number;
  private TypeCarriage typeCarriage;
  private long id_typeCarriage;
  private Train train;
  private long id_train;

  public Carriage() {
  }

  public Carriage(long id, int number, TypeCarriage typeCarriage, long id_typeCarriage, Train train,
      long id_train) {
    super(id);
    this.number = number;
    this.typeCarriage = typeCarriage;
    this.id_typeCarriage = id_typeCarriage;
    this.train = train;
    this.id_train = id_train;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public TypeCarriage getTypeCarriage() {
    return typeCarriage;
  }

  public void setTypeCarriage(TypeCarriage typeCarriage) {
    this.typeCarriage = typeCarriage;
    id_typeCarriage = typeCarriage.getId();
  }

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
    id_train = train.getId();
  }

  public long getId_typeCarriage() {
    return id_typeCarriage;
  }

  public void setId_typeCarriage(long id_typeCarriage) {
    this.id_typeCarriage = id_typeCarriage;
    this.typeCarriage.setId(id_typeCarriage);
  }

  public long getId_train() {
    return id_train;
  }

  public void setId_train(long id_train) {
    this.id_train = id_train;
    this.train.setId(id_train);
  }

  @Override
  public String toString() {
    return "Carriage{" +
        "id=" + getId() +
        ", number=" + number +
        ", typeCarriage=" + typeCarriage +
        ", id_typeCarriage=" + id_typeCarriage +
        ", train=" + train +
        ", id_train=" + id_train +
        '}';
  }
}
