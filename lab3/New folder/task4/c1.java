class c1 {
  public static void main(String[] args){
    c1 ob1 = new c1();
    Object ob2 = ob1;
    System.out.println(ob2 instanceof Object);
    System.out.println(ob2 instanceof c1);
  }
}