public class Developer extends Employee {
    Developer(String name, double salary){
        super(name,salary);
    }

    @Override
    double getBonus(){
        if(super.getSalary()<=50000){
            return 0.0;
        }
        return super.getSalary()*0.05;
    }
}
