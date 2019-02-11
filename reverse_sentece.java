
public void reverse(String str){
  if (str == null) return; 
  if (str.length == 0) return;
  StringBuilder builder  = new StringBuilder();
  for (String temp : str.split(" ")){
    temp = temp + " ";
    builder.insert(0, temp);
  }
}
