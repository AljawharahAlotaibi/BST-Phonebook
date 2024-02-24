// This class will represent the BST data structure used to store the contacts (you will
// only use one BST to store contacts).
public class ContactBST {
    private ContactBSTNode root, current;

    public ContactBST() {
        root = current = null;
    }
    public boolean empty(){
        return root==null;
    }
    public boolean full(){
        return false;
    }
    public Contact retrieve(){
        return current.data;
    }
  public boolean findKey(String tKey) {
        ContactBSTNode p=root, q=root;
        if(empty())
            return false;
        while (p != null) {
            q=p;
            int comparison = p.data.compareTo(tKey);
            if (comparison == 0) {
                current=p;
                return true;
            } else if (comparison < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        current=q;
        return false;
    }

    public boolean insert(String k,Contact val) {
        ContactBSTNode p,q=current;

        if(findKey(k)){
            System.out.println("Contact already exists");
            current=q;
            return false;
        }
        p=new ContactBSTNode(k,val);
        if(empty()){
            root=current=p;
            return true;
        }
        else{
            if(current.data.compareTo(k)>0)
                current.left=p;
            else
                current.right=p;
            current=p;
            return true;
        }
    }//end insert()
    
    public ContactBSTNode getRoot() {
        return root;
    }

   
   public ContactBST searchContact(String searchChoice){
       ContactBST resultBST = new ContactBST();
       if(root==null)
       return this;
   inorderInsertion(root,resultBST,searchChoice);
   return resultBST;  
   }
           
   public void inOrderPrint(ContactBSTNode node){
   if(node.left==null && node.right==null)//base case
   System.out.println((node.data).toString());
   else{
         if(node.left!=null) 
         inOrderPrint(node.left);
         System.out.println((node.data).toString());
         if(node.right!=null)
         inOrderPrint(node.right);
        }
   }//end inorderPrint()   
        
   public void inOrderPrintName(ContactBSTNode node){
   if(node.left==null && node.right==null)//base case
   System.out.print(node.data.getContactName()+" ");
   else{
         if(node.left!=null) 
         inOrderPrint(node.left);
         System.out.print(node.data.getContactName()+" ");
         if(node.right!=null)
         inOrderPrint(node.right);
        }
   }//end inOrderPrintName() 
   public void inorderInsertion(ContactBSTNode node,ContactBST insertionBST,String searchchoice){
   if(node.left==null && node.right==null)//base case
     { if((node.data).getAddress().equalsIgnoreCase(searchchoice)||
           (node.data).getEmailAddress().equalsIgnoreCase(searchchoice)||
           (node.data).getBirthday().equalsIgnoreCase(searchchoice) ||
               (node.data).getContactName().equalsIgnoreCase(searchchoice)||
           (node.data).getPhoneNumber().equalsIgnoreCase(searchchoice))
        insertionBST.insert((node.data).getContactName(),node.data); 
     }//end if
   else{
         if(node.left!=null) 
         inorderInsertion(node.left,insertionBST,searchchoice);
     if((node.data).getAddress().equalsIgnoreCase(searchchoice)||
           node.data.getEmailAddress().equalsIgnoreCase(searchchoice)||
           node.data.getBirthday().equalsIgnoreCase(searchchoice) ||
               node.data.getContactName().equalsIgnoreCase(searchchoice)||
           node.data.getPhoneNumber().equalsIgnoreCase(searchchoice))
       insertionBST.insert((node.data).getContactName(),node.data); 
         if(node.right!=null)
         inorderInsertion(node.right,insertionBST,searchchoice);
        }
   }//end inorderInsertion()

public ContactBST searchForFirstName(String firstName){
ContactBST searchBST = new ContactBST();
       if(root==null)
       return this;
   inorderFirstNameInsertion(root,searchBST,firstName);
   return searchBST; 
}

public void inorderFirstNameInsertion(ContactBSTNode node,ContactBST firstNameInsertBST,String firstName){
  String thisFirstName = ((node.data).getContactName()).substring(0,(((node.data).getContactName()).indexOf(' ')));
  if(node.left==null && node.right==null)//base case
     {    if(thisFirstName.equalsIgnoreCase(firstName))
          firstNameInsertBST.insert((node.data).getContactName(),node.data); 
     }
   else{
         if(node.left!=null) 
             inorderFirstNameInsertion(node.left,firstNameInsertBST,firstName);
              if(thisFirstName.equalsIgnoreCase(firstName))  
              firstNameInsertBST.insert((node.data).getContactName(),node.data); 
        
         if(node.right!=null)
         inorderFirstNameInsertion(node.right,firstNameInsertBST,firstName);
        }
    }//end inorderFirstNameInsertion()
    
    
    public Contact removeContact(String fullName) {
                    String key = fullName;
                
                    ContactBSTNode parent = null;
                    ContactBSTNode current = root;
                
                    while (current != null) {
                        if (current.getKey().equalsIgnoreCase(key)) {
                            // Node to remove found
                
                            // Case 1: No children (leaf node)
                            if (current.getLeft() == null && current.getRight() == null) {
                                if (parent == null) {
                                    root = null;  // Removing the root node
                                } else if (parent.getLeft() == current) {
                                    parent.setLeft(null);  // Removing a left child
                                } else {
                                    parent.setRight(null);  // Removing a right child
                                }
                            }
                            // Case 2: One child
                            else if (current.getLeft() == null) {
                                if (parent == null) {
                                    root = current.getRight();  // Removing the root node
                                } else if (parent.getLeft() == current) {
                                    parent.setLeft(current.getRight());  // Removing a left child
                                } else {
                                    parent.setRight(current.getRight());  // Removing a right child
                                }
                            } else if (current.getRight() == null) {
                                if (parent == null) {
                                    root = current.getLeft();  // Removing the root node
                                } else if (parent.getLeft() == current) {
                                    parent.setLeft(current.getLeft());  // Removing a left child
                                } else {
                                    parent.setRight(current.getLeft());  // Removing a right child
                                }
                            }
                            // Case 3: Two children
                            else {
                                ContactBSTNode successor = findMin(current.getRight());
                                current.setKey(successor.getKey());
                                current = successor;
                                continue;
                            }
                            System.out.println(fullName + " was deleted successfully ");
                            return current.getData();  // Return the removed contact
                        }
                
                        // Update parent and current references for traversal
                        parent = current;
                        if (key.compareToIgnoreCase(current.getKey()) < 0) {
                            current = current.getLeft();
                        } else {
                            current = current.getRight();
                        }
                    }
                
                     System.out.println(" Contact not found ");
                    return null;  // Node with the specified key not found
                }
                

                public ContactBSTNode findMin(ContactBSTNode node) {
                    while (node.getLeft() != null) {
                        node = node.getLeft();
                    }
                    return node;
                }



}

