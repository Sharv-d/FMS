package my_package;


public class Flights {
    private String name;
    private String source;
    private String destination;
    private int duration;
    private int fare;


public Flights(String Name,String Source,String Destination,int Duration,int Fare)
{
this.name=Name;
this.source=Source;
this.destination=Destination;
this.duration=Duration;
this.fare=Fare;
}

    Flights(String string, String string0, boolean add) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Flights(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public String getName(){
    return name;
}
public String getSource(){
    return source;
    
}
public String getDestination(){
    return destination;
}
public int getDuration(){
    return duration;
}
public int getFare(){
    return fare;
}
}
