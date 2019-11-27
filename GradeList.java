import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GradeList {
    private List<Double> grades;
    
    
    public GradeList() {
        List<Double> grades = new ArrayList<Double>();
    }
    
    public void readGrades(String fileName) throws FileNotFoundException{
    
        FileInputStream f = new FileInputStream(fileName);
        if(f==null)
        {
          throws FileNotFoundException("File not found"); 
        }
        f.close();
        Scanner in = new Scanner(fileName);
        while(in.hasNextDouble()){
            double token = in.nextDouble();
            grades.add(token);
        }
        
    }
    
    public double calcAverage() {
        if (grades.size() == 0){
            return 0.0;
        }
        double sum = 0.0 ;
        for(int i = 0 ; i < grades.size(); i++){
            sum += grades.get(i);
        }
        double Avg = sum / grades.size();
        return Avg;
    }
    
    public double dropLowest() {
        if(grades.size() == 0){
            return Double.MAX_VALUE;
        }
        double temp =Double.MAX_VALUE;
        for(int i = 0 ; i < grades.size(); i ++){
            if(temp < grades.get(i)){
                temp = grades.get(i);
            }
        }
        return temp;
    }
    
    public void addGrade(double grade) {
        int val = grades.size(); 
        grades.set(val, grade);
        
    }
    
    public boolean removeAllGrades(double grade) 
    {
        boolean isFound = false;
        for(int i = 0; i < grades.size(); i++)
        {
            if(grades.get(i)== grade)
            {
                grades.remove(grade);
                isFound= true;
               
            }
        }
        return isFound;
    }
    
    public void printSortedGrades() 
    {
        Collections.sort(grades);
        System.out.println(grades.toString());
    }
    
    public String toString() {
        if(grades.size() == 0 ){
            return "[]";
        }else{
            String result = "["+grades.get(0);
            for(int i = 1; i< grades.size(); i++){
                result += ","+ grades.get(i);
            }
            result +="]";
            return result;
            
        }
        
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= grades.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    private void checkCapacity(int capacity) {
        if (capacity > grades.size()) {
            throw new IllegalStateException("would exceed list capacity");
        }
    }
    
}