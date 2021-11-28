package hiber.model;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="cars")
//public class Car {
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    private int series;
//    private String model;
//
//    @OneToOne(optional=false, mappedBy="car")
//    private User owner;
//
//    public Car() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//    public String getModel(){
//        return model;
//    }
//    public void  setModel(String model){
//        this.model=model;
//    }
//    public void  setSeries(int series){
//        this.series=series;
//    }
//    public int getSeries(){
//        return series;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public Car(String model, int series) {
//
//    }
//}