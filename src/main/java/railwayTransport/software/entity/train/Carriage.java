package railwayTransport.software.entity.train;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import railwayTransport.software.entity.BaseEntity;

import javax.persistence.*;

@Entity
public class Carriage extends BaseEntity {

  private int number;
  @ManyToOne
  @JoinColumn(name = "type_carriage_id")
  private TypeCarriage typeCarriage;
  @JsonBackReference(value = "train-carriage")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "train_id")
  private Train train;

  public Carriage(int number, TypeCarriage typeCarriage) {
    this.number = number;
    this.typeCarriage = typeCarriage;
  }



  public Carriage() {
  }

  public Carriage(int number, TypeCarriage typeCarriage/*, long id_typeCarriage*/, Train train /*,
      long id_train*/) {
    this.number = number;
    this.typeCarriage = typeCarriage;
    //this.id_typeCarriage = id_typeCarriage;
    this.train = train;
    //this.id_train = id_train;
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
//    id_typeCarriage = typeCarriage.getId();
  }

  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
//    id_train = train.getId();
  }

//  public long getId_typeCarriage() {
//    return id_typeCarriage;
//  }

  public void setId_typeCarriage(long id_typeCarriage) {
//    this.id_typeCarriage = id_typeCarriage;
    this.typeCarriage.setId(id_typeCarriage);
  }

//  public long getId_train() {
//    return id_train;
//  }

  public void setId_train(long id_train) {
//    this.id_train = id_train;
    this.train.setId(id_train);
  }

  @Override
  public String toString() {
    return "CarriageMapper{" +
        "id=" + getId() +
        ", number=" + number +
        ", typeCarriage=" + typeCarriage +
//        ", id_typeCarriage=" + id_typeCarriage +
        ", train=" + train +
//        ", id_train=" + id_train +
        '}';
  }
}
