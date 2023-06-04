abstract class Vehicle{
    protected String ID, make, model, manufacture_year;
    public Vehicle(String ID, String make, String model, String manufacture_year){
        this.ID = ID;
        this.make = make;
        this.model =model;
        this.manufacture_year = manufacture_year;
    }

    public void showInformation(){
        System.out.println("Vehicle ID: "+ID);
        System.out.println("Vehicle make: " + make);
        System.out.println("Vehicle model: "+model);
        System.out.println("Vehicle manufature year: "+manufacture_year);
    }

    abstract void service();
}

class MotorCycle extends Vehicle{
    private String engine_displacement;
    private boolean ABS;
    public MotorCycle next;

    public MotorCycle(String ID, String make, String model, String manufacture_year, String ed, boolean abs){
        super(ID, make, model, manufacture_year);
        engine_displacement = ed;
        ABS = abs;
        next = null;
    }

    public void showInformation(){
        System.out.println("\n");
        System.out.println("MotorCycle ID: "+ID);
        System.out.println("MotorCycle make: " + make);
        System.out.println("MotorCycle model: "+model);
        System.out.println("MotorCycle manufature year: "+manufacture_year);
        System.out.println("MotorCycle Engine displacement: " + engine_displacement);
        System.out.println("MotorCycle ABS: " + ABS);
        System.out.println("\n");
    }


    public void service(){
        System.out.println("Motorcycle service includes engine check, chain lubrication, and brake inspection.");
    }
}

class Car extends Vehicle{
    private String body_type;
    private int num_doors;
    public Car next;

    public Car(String ID, String make, String model, String manufacture_year, String bt, int n){
        super(ID, make, model, manufacture_year);
        body_type = bt;
        num_doors = n;
        next = null;
    }

    public void showInformation(){
        System.out.println("\n");
        System.out.println("Car ID: "+ID);
        System.out.println("Car make: " + make);
        System.out.println("Car model: "+model);
        System.out.println("Car manufature year: "+manufacture_year);
        System.out.println("Car Engine displacement: " + body_type);
        System.out.println("Car ABS: " + num_doors);
        System.out.println("\n");
    }

    public void service(){
        System.out.println("Car service includes engine check, tire rotation, and brake inspection.");
    }
}

class Truck extends Vehicle{
    private double capacity;
    private String permit_type;
    public Truck next;

    public Truck(String ID, String make, String model, String manufacture_year, double capacity, String permit_type){
        super(ID, make, model, manufacture_year);
        this.capacity = capacity;
        this.permit_type = permit_type;
        next = null;
    }

    public void showInformation(){
        System.out.println("\n");
        System.out.println("Truck ID: "+ID);
        System.out.println("Truck make: " + make);
        System.out.println("Truck model: "+model);
        System.out.println("Truck manufature year: "+manufacture_year);
        System.out.println("Truck Capacity: " + capacity);
        System.out.println("Truck permit: " + permit_type);
        System.out.println("\n");
    }

    public void service(){
        System.out.println("Car service includes engine check, tire rotation, and brake inspection.");
    }
}

class ServiceCenter{
    public MotorCycle m_head;
    public Car c_head;
    public Truck t_head;
    public int m, c, t;

    ServiceCenter(){
        m_head = null;
        c_head = null;
        t_head = null;

        m = 0;
        c = 0;
        t = 0;
    }

    public void addVehicle(MotorCycle new_node){
        if(m_head == null){
            m_head = new_node;
            m_head.next = null;
        }
        else{
            new_node.next = m_head;
            m_head = new_node;
        }
        m++;
    }

    public void addVehicle(Car new_node){
        if(c_head == null){
            c_head = new_node;
            c_head.next = null;
        }
        else{
            new_node.next = c_head;
            c_head = new_node;
        }
        c++;
    }

    public void addVehicle(Truck new_node){
        if(m_head == null){
            t_head = new_node;
            t_head.next = null;
        }
        else{
            new_node.next = t_head;
            t_head = new_node;
        }
        t++;
    }

    public void removeVehicle(String id){
        if(id.charAt(0) == 'm'){
            if(m_head == null)
                return;
            else{
                if(m_head.ID == id){
                    m_head = m_head.next;
                    return;
                }
                MotorCycle temp = m_head.next;
                MotorCycle prev = m_head;
                while(temp != null){
                    if(temp.ID == id){
                        prev.next = temp.next;
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
            m--;
        }    
        else if(id.charAt(0) == 'c'){
            if(c_head == null)
                return;
            else{
                if(c_head.ID == id){
                    c_head = c_head.next;
                    return;
                }
                Car temp = c_head.next;
                Car prev = c_head;
                while(temp != null){
                    if(temp.ID == id){
                        prev.next = temp.next;
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
            c--;
        } 
        else{
            if(t_head == null)
                return;
            else{
                if(t_head.ID == id){
                    t_head = t_head.next;
                    return;
                }
                Truck temp = t_head.next;
                Truck prev = t_head;
                while(temp != null){
                    if(temp.ID == id){
                        prev.next = temp.next;
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
        }
        t--;
    }

    public void displayVehicles(){
        if(m_head != null){
            System.out.println("\n\nMOTORCYCLES:");
            MotorCycle temp = m_head;
            while(temp!=null){
                temp.showInformation();
                temp = temp.next;
            }
        }

        if(c_head != null){
            System.out.println("\n\nCARS:");
            Car temp = c_head;
            while(temp!=null){
                temp.showInformation();
                temp = temp.next;
            }
        }

        if(t_head != null){
            System.out.println("\n\nTRUCKS:");
            Truck temp = t_head;
            while(temp!=null){
                temp.showInformation();
                temp = temp.next;
            }
        }

    }

    public void performService(String id){
        if(id.charAt(0) == 'm'){
            if(m_head == null)
                return;
            else{
                if(m_head.ID == id){
                    System.out.println("SERVICE STARTED");
                    m_head.showInformation();
                    m_head.service();
                    return;
                }
                MotorCycle temp = m_head.next;
                MotorCycle prev = m_head;
                while(temp != null){
                    if(temp.ID == id){
                        System.out.println("SERVICE STARTED");
                        temp.showInformation();
                        temp.service();
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
        }    
        else if(id.charAt(0) == 'c'){
            if(c_head == null)
                return;
            else{
                if(c_head.ID == id){
                    System.out.println("SERVICE STARTED");
                    c_head.showInformation();
                    c_head.service();
                    return;
                }
                Car temp = c_head.next;
                Car prev = c_head;
                while(temp != null){
                    if(temp.ID == id){
                        System.out.println("\n\nSERVICE STARTED");
                        temp.showInformation();
                        temp.service();
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
        } 
        else{
            if(t_head == null)
                return;
            else{
                if(t_head.ID == id){
                    System.out.println("\n\nSERVICE STARTED");
                    t_head.showInformation();
                    t_head.service();
                    return;
                }
                Truck temp = t_head.next;
                Truck prev = t_head;
                while(temp != null){
                    if(temp.ID == id){
                        System.out.println("\n\nSERVICE STARTED");
                        temp.showInformation();
                        temp.service();
                        return;
                    }
                    temp = temp.next;
                    prev = prev.next;
                }
            }
        }
    }

}

public class ServiceCenterMain {
    public static void main(String args[]){
        ServiceCenter SC = new ServiceCenter();
        
        SC.addVehicle(new Car("c1", "sedan", "honda city", "2005", "classy", 4));
        SC.addVehicle(new Car("c2", "hachpack", "alto", "2000", "city car", 4));
        SC.addVehicle(new Car("c3", "suv", "Scorpio", "1995", "big car", 7));

        SC.addVehicle(new MotorCycle("m1", "city bike", "sp 125", "2020", "125cc", true));
        SC.addVehicle(new MotorCycle("m2", "sport", "pulser 220", "2005", "220cc", false));
        SC.addVehicle(new MotorCycle("m3", "heavy", "RE Classic 350", "1975", "350cc", false));
        
        SC.addVehicle(new Truck("t1", "small", "chota hathi", "2003", 1000, "State"));
        SC.addVehicle(new Truck("t2", "medium", "Lorry", "1950", 25000, "National"));
        SC.addVehicle(new Truck("t3", "big", "18 wheel giant", "1990", 75000, "International"));  

        SC.removeVehicle("c2");
        SC.removeVehicle("t1");
        SC.removeVehicle("m3");


        SC.addVehicle(new Car("c2", "hachpack", "alto", "2000", "city car", 4));
        SC.addVehicle(new MotorCycle("m3", "heavy", "RE Classic 350", "1975", "350cc", false));
        SC.addVehicle(new Truck("t1", "small", "chota hathi", "2003", 1000, "State"));
        //SC.displayVehicles();

        SC.performService("t3");
        SC.performService("c3");
        SC.performService("m2");
    }
}
