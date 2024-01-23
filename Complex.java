import java.util.*;
class Student{
    private String name;
private int id,p,c,m,t;
void accept(){
    String str;
    Scanner sc =new Scanner(System.in);
    System.out.println("Enter name,Id,Marks in physics,Chemistry and maths");
    name=sc.nextLine();
    id=sc.nextInt();
    p=sc.nextInt();
    c=sc.nextInt();
    m=sc.nextInt();
    t=p+c+m;
}
void display(){
    System.out.println(name+"\t"+id+"\t"+p+"\t"+c+"\t"+m+"\t"+t);
}
}
class Complex{
public static void main(String[] args) {
    int n,i;
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter number of Students");
    n=sc.nextInt();
    Student s []= new Student[n];
    for(i=0;i<=n-1;i++)
    {
    s[i]= new Student();
     s[i].accept();
    }
   System.out.println("Name\tid\tphy\tchem\tmaths\ttotal");
 for(i=0;i<=n-1;i++){
    s[i].display();
 }
}
}