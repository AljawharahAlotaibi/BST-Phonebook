public class ContactBSTNode {
    public String key;
    public Contact data;
    public ContactBSTNode left,right;

    public ContactBSTNode(String k, Contact val){
        key=k;
        data=val;
        left=right=null;
    }
    public ContactBSTNode(String k, Contact val, ContactBSTNode l,ContactBSTNode r){
        key=k;
        data=val;
        left=l;
        right=r;
    }
    
     public String getKey(){
    return key;
    }
    
    public ContactBSTNode getLeft(){
    return left;
    }
    
    public ContactBSTNode getRight(){
    return right;
    }
    
     public void setLeft(ContactBSTNode n){
    left = n;
    }
    
    public void setRight(ContactBSTNode n){
    right = n;
    }
    
    public void setKey(String n){
    key = n;
    }
    
    public Contact getData(){
    return data;
    }

}
